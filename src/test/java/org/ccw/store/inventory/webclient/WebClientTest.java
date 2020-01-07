package org.ccw.store.inventory.webclient;


import org.ccw.store.inventory.model.Inventory;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.reactive.function.client.WebClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class WebClientTest {

    private WebClient webClient = WebClient.builder().baseUrl("http://localhost:8080").build();

    @Test
    public void testGetAlInventories() {
        webClient.get().uri("/inventories")
                .accept(MediaType.APPLICATION_JSON).retrieve().toEntityList(Inventory.class);
    }

    @Test
    public void testGetnventoriesByPage() {
        webClient.get().uri("/inventories/page/1?size=1")
                .accept(MediaType.APPLICATION_JSON).retrieve().toEntityList(Inventory.class);
    }

}
