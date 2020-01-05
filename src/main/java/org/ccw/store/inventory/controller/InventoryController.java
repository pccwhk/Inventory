package org.ccw.store.inventory.controller;

import java.util.List;
import org.ccw.store.inventory.model.Inventory;
import org.ccw.store.inventory.repo.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("inventories")
public class InventoryController {

    @Autowired
    private InventoryRepository inventoryRepository;

    /*
    @RequestMapping(method = RequestMethod.POST)
    public Inventory newInventory(@RequestBody Inventory inventory) {
        inventoryRepository.saveAndFlush(inventory);
        return inventory;
    }

        @RequestMapping(method = RequestMethod.PUT)
    public String updateInventory(@RequestBody Inventory inventory) {
        //inventoryRepository.
        inventoryRepository.saveAndFlush(inventory);
        return ("OK");
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }*/

    @RequestMapping(method = RequestMethod.PUT)
    public String updateInventory(@RequestBody Inventory inventory) {
        //inventoryRepository.
        inventoryRepository.saveAndFlush(inventory);
        return ("OK");
    }


    @GetMapping(path = "/query")
    @ResponseBody
    public List<Inventory> findByName(@RequestParam(name="name") String name){
        System.out.println("calling find by name");
        return inventoryRepository.findByName(name);
    }
}
