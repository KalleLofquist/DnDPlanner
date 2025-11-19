package se.karl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import se.karl.appconfig.App;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PlanControllerTest {
    @LocalServerPort
    int port;

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void testHello() {
        String body = this.restTemplate.getForObject("http://localhost:" + port + "/hello", String.class);
        assertThat(body).isEqualTo("Hello World!");
    }
}