package org.ccw.store.inventory.webclient;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.reactive.function.client.WebClient;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class WebClientTest {

    @Autowired
    private WebClient webClient;

    @Test
    public void testExampleOneStepFurther() {
        /*
        webClient
                .get().uri("/inventories/all")
                .accept(MediaType.TEXT_PLAIN).retrieve().bodyToFlux()*/
                //.expectBody(String.class).isEqualTo("Hello, Spring Webflux Example 1!");

    }

}
