package com.vlstr.bcmbackend.provider;

import com.vlstr.bcmbackend.domain.Flight_AirJazz;
import com.vlstr.bcmbackend.domain.enums.Provider;
import com.vlstr.bcmbackend.util.HttpHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Component
public class AirJazzProvider {

    private static final Logger logger = LoggerFactory.getLogger(AirJazzProvider.class);

    private final HttpHelper httpHelper;

    public AirJazzProvider(HttpHelper httpHelper) {
        this.httpHelper = httpHelper;
    }

    public CompletableFuture<List<Flight_AirJazz>> getFlights() {
        String url = httpHelper.getFullEndpointUrl(Provider.AIR_JAZZ);
        HttpEntity<String> entity = httpHelper.getDefaultEntity();

        RestTemplate restTemplate = new RestTemplate();

        return CompletableFuture.supplyAsync(() -> {

            ResponseEntity<Flight_AirJazz[]> airJazzResponse =
                    restTemplate.exchange(url, HttpMethod.GET, entity, Flight_AirJazz[].class);
            Optional<Flight_AirJazz[]> flights = Optional.ofNullable(airJazzResponse.getBody());

            if (flights.isPresent()) {
                return Arrays.asList(flights.get());
            } else {
                logger.error(airJazzResponse.getStatusCode().getReasonPhrase());
                return null;
            }
        });
    }
}
