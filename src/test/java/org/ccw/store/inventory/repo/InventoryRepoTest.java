package org.ccw.store.inventory.repo;

import org.ccw.store.inventory.model.Inventory;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

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

    public InventoryRepoTest(DataSource dataSource) {
        this.dataSource = dataSource;
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
        Inventory i = new Inventory();

        inventoryRepository.save(i);
    }
}
