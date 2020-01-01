package org.ccw.store.inventory.repo;

import org.ccw.store.inventory.model.Inventory;
import org.ccw.store.inventory.model.Subcategory;
import org.springframework.data.repository.CrudRepository;

public interface SubCategoryRepository extends CrudRepository<Subcategory, Long> {
}
