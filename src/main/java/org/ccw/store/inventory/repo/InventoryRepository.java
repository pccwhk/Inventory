package org.ccw.store.inventory.repo;


import java.util.List;
import org.ccw.store.inventory.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    @Query("select i from Inventory i where i.name = ?1")
    List<Inventory> findByName(String name);
}
