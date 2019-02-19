package com.vlstr.bcmbackend.provider;

import com.vlstr.bcmbackend.AppConfiguration;
import com.vlstr.bcmbackend.domain.Flight_AirMoon;
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
import java.util.logging.Level;

@Component
public class AirMoonProvider {

    private static final Logger logger = LoggerFactory.getLogger(AirMoonProvider.class);

    private final HttpHelper httpHelper;

    public AirMoonProvider(HttpHelper httpHelper) {
        this.httpHelper = httpHelper;
    }

    public CompletableFuture<List<Flight_AirMoon>> getFlights() {
        String url = httpHelper.getFullEndpointUrl(Provider.AIR_MOON);
        HttpEntity<String> entity = httpHelper.getDefaultEntity();

        RestTemplate restTemplate = new RestTemplate();

        return CompletableFuture.supplyAsync(() -> {
            ResponseEntity<Flight_AirMoon[]> airMoonResponse =
                    restTemplate.exchange(url, HttpMethod.GET, entity, Flight_AirMoon[].class);
            Optional<Flight_AirMoon[]> flights = Optional.ofNullable(airMoonResponse.getBody());

            if (flights.isPresent()) {
                return Arrays.asList(flights.get());
            } else {
                logger.error(airMoonResponse.getStatusCode().getReasonPhrase());
                return null;
            }
        });
    }
}
