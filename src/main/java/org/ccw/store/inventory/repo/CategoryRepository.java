package org.ccw.store.inventory.repo;

import java.util.List;
import org.ccw.store.inventory.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("select i from Category i where i.name = ?1")
    List<Category> findByName(String name);
}
