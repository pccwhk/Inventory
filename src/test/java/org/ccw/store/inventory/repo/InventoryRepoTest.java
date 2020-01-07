package org.ccw.store.inventory.repo;


import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import org.ccw.store.inventory.model.Category;
import org.ccw.store.inventory.model.Inventory;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
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
    public void injectedComponentsAreNotNull(){
        assertThat(dataSource).isNotNull();
        assertThat(jdbcTemplate).isNotNull();
        assertThat(entityManager).isNotNull();
        assertThat(inventoryRepository).isNotNull();
    }

    @Test
    public void inventoryPersistTest(){
        String name = "TEST";
        long qty = 1000L;
        List<Inventory> list = inventoryRepository.findByName(name);
        assertThat(list.isEmpty());

        Optional<Category> c = categoryRepository.findById(3L);
        if (c.isPresent()) {
            Inventory i = new Inventory();
            i.setName(name);
            i.setQuantity(qty);
            i.setSubcategory(c.get());
            inventoryRepository.saveAndFlush(i);
        }

        list = inventoryRepository.findByName(name);
        assertThat(!list.isEmpty());
        assertThat(list.get(0).getQuantity() == qty);
        assertThat(name.equals(list.get(0).getName()));
        assertThat(list.get(0).getInventoryId() != null);
    }
}
