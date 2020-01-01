package org.ccw.store.inventory.repo;

import org.ccw.store.inventory.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long>{
}
