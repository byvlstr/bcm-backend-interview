package com.vlstr.bcmbackend;

import com.vlstr.bcmbackend.domain.Flight;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FlightControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testFlightsAPI_shouldReturnExpectedResults() {
        Flight[] result = this.restTemplate.getForObject("http://localhost:" + port + "/api/flights", Flight[].class);
        assertThat(result).hasSize(50);
        assertThat(result).isSortedAccordingTo(Comparator.comparingDouble(Flight::getPrice));
    }
}
