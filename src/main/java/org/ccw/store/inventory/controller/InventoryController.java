package org.ccw.store.inventory.controller;

import java.util.List;
import java.util.Optional;
import org.ccw.store.inventory.dto.InventoryDTO;
import org.ccw.store.inventory.model.Category;
import org.ccw.store.inventory.model.Inventory;
import org.ccw.store.inventory.repo.CategoryRepository;
import org.ccw.store.inventory.repo.InventoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("inventories")
public class InventoryController {

    private Logger logger = LoggerFactory.getLogger(InventoryController.class);

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(method = RequestMethod.POST)
    public Optional<Inventory> newInventory(@RequestBody InventoryDTO inventoryDTO) {
        Optional<Category> c = categoryRepository.findById(inventoryDTO.getCategoryId());
        if (c.isPresent()) {
            Inventory inventory = new Inventory();
            inventory.setName(inventoryDTO.getName());
            inventory.setQuantity(inventoryDTO.getQty());
            inventory.setSubcategory(c.get());
            inventoryRepository.saveAndFlush(inventory);
            return Optional.of(inventory);
        }
        else {
            return Optional.empty();
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public Page<Inventory> getAllInventories() {
        return inventoryRepository.findAll(PageRequest.of(1, 3));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Optional<Inventory> updateInventory(@RequestBody InventoryDTO inventoryDTO) {
        Optional<Inventory> inventory = inventoryRepository.findById(inventoryDTO.getInventoryId());
        if (inventory.isPresent()) {
            Inventory inv = inventory.get();
            inv.setQuantity(inventoryDTO.getQty());
            inv.setName(inventoryDTO.getName());
            inv.setInventoryId(inventoryDTO.getInventoryId());
            inventoryRepository.saveAndFlush(inv);
            return Optional.of(inv);
        }
        return Optional.empty();
    }


    @GetMapping(path = "/query")
    public List<Inventory> findByName(@RequestParam(name="name") String name){
        logger.debug("query by name");
        return inventoryRepository.findByName(name);
    }

    @DeleteMapping("/{id}")
    void deleteEmployee(@PathVariable Long id) {
        inventoryRepository.deleteById(id);
    }
}
