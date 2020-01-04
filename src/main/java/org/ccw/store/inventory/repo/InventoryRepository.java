package org.ccw.store.inventory.repo;


import org.ccw.store.inventory.model.Inventory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@RepositoryRestResource
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

}
