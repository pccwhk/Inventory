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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("inventories")
public class InventoryController {

    private Logger logger = LoggerFactory.getLogger(InventoryController.class);

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Inventory> newInventory(@RequestBody InventoryDTO inventoryDTO) {
        Optional<Category> c = categoryRepository.findById(inventoryDTO.getCategoryId());
        if (c.isPresent()) {
            // only allow subcategory to be added to a inventory
            if (c.get().getParentCategory() != null) {
                Inventory inventory = new Inventory();
                inventory.setName(inventoryDTO.getName());
                inventory.setQuantity(inventoryDTO.getQty());
                inventory.setSubcategory(c.get());
                inventoryRepository.saveAndFlush(inventory);
                return ResponseEntity.accepted().body(inventory);
            }
            else {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Subcateogory (instead of category) needed for inventory");
            }
        }
        else {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Subcateogory NOT FOUND for inventory");
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Inventory> getAllInventories() {
        return inventoryRepository.findAll();
    }

    @RequestMapping(path = "/page/{pageid}", method = RequestMethod.GET)
    public Page<Inventory> getAllInventoriesWithPage(@PathVariable int pageid, @RequestParam("size") int size) {
        return inventoryRepository.findAll(PageRequest.of(pageid, size));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Inventory> updateInventory(@RequestBody InventoryDTO inventoryDTO) {
        Optional<Inventory> inventory = inventoryRepository.findById(inventoryDTO.getInventoryId());
        if (inventory.isPresent()) {
            Inventory inv = inventory.get();
            inv.setQuantity(inventoryDTO.getQty());
            inv.setName(inventoryDTO.getName());
            inv.setInventoryId(inventoryDTO.getInventoryId());
            inventoryRepository.saveAndFlush(inv);
            return ResponseEntity.accepted().body(inv);
        }
        throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Inventory ID NOT FOUND for inventory");
    }


    @GetMapping(path = "/name/{name}")
    public List<Inventory> findByName(@PathVariable(name="name") String name){
        logger.debug("query by name");
        return inventoryRepository.findByName(name);
    }

    @DeleteMapping("/id/{id}")
    void deleteEmployee(@PathVariable Long id) {
        inventoryRepository.deleteById(id);
    }
}
