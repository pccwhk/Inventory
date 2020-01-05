package org.ccw.store.inventory.repo;


import java.util.Optional;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import org.ccw.store.inventory.model.Category;
import org.ccw.store.inventory.model.Inventory;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;


import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class InventoryRepoTest {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public InventoryRepoTest() {
    }

    @Test
    void injectedComponentsAreNotNull(){
        assertThat(dataSource).isNotNull();
        assertThat(jdbcTemplate).isNotNull();
        assertThat(entityManager).isNotNull();
        assertThat(inventoryRepository).isNotNull();
    }

    @Test
    public void inventoryPersistTest(){
        Optional<Category> c = categoryRepository.findById(8L);
        if (c.isPresent()) {
            Inventory i = new Inventory();
            i.setName("abc");
            i.setQuantity(1222L);
            i.setSubcategory(c.get());
            inventoryRepository.save(i);
        }
    }
}
