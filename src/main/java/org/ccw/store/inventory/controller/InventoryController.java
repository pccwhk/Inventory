package org.ccw.store.inventory.controller;

import org.ccw.store.inventory.model.Inventory;
import org.ccw.store.inventory.repo.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("inventories")
public class InventoryController {

    @Autowired
    private InventoryRepository inventoryRepository;

    /*
    @RequestMapping(value = "/addInventory", method = RequestMethod.POST)
    public String newEmployee(Inventory inventory) {
        inventoryRepository.save(inventory);
        return ("OK");
    }*/

    //@RequestMapping(value = "/list", method = RequestMethod.GET)
    @GetMapping("/all")
    public List<Inventory> getAllInventory(Inventory inventory) {
        return inventoryRepository.findAll();
    }
}
