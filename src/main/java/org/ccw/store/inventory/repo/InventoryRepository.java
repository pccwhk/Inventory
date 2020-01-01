package org.ccw.store.inventory.repo;


import org.ccw.store.inventory.model.Inventory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface InventoryRepository extends CrudRepository<Inventory, Long> {

    List<Inventory> findByName(String name);


}
