package com.vlstr.bcmbackend.service;

import com.vlstr.bcmbackend.AppConfiguration;
import com.vlstr.bcmbackend.domain.Flight;
import com.vlstr.bcmbackend.domain.Flight_AirJazz;
import com.vlstr.bcmbackend.domain.Flight_AirMoon;
import com.vlstr.bcmbackend.domain.enums.Provider;
import com.vlstr.bcmbackend.provider.AirBeamProvider;
import com.vlstr.bcmbackend.provider.AirJazzProvider;
import com.vlstr.bcmbackend.provider.AirMoonProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class FlightService {

    private static final Logger logger = LoggerFactory.getLogger(AirJazzProvider.class);

    private final AppConfiguration config;
    private final AirJazzProvider airJazzProvider;
    private final AirMoonProvider airMoonProvider;
    private final AirBeamProvider airBeamProvider;

    public FlightService(AppConfiguration config, AirJazzProvider airJazzProvider, AirMoonProvider airMoonProvider, AirBeamProvider airBeamProvider) {
        this.config = config;
        this.airJazzProvider = airJazzProvider;
        this.airMoonProvider = airMoonProvider;
        this.airBeamProvider = airBeamProvider;
    }

    public List<Flight> getFlights() {

        List<Flight> flightResults = new ArrayList<>();
        CompletableFuture<List<Flight_AirJazz>> completableAirJazzFlights = airJazzProvider.getFlights();
        CompletableFuture<List<Flight_AirMoon>> completableAirMoonFlights = airMoonProvider.getFlights();

        flightResults.addAll(completableAirJazzFlights.join().stream()
                .map(flight -> new Flight(Provider.AIR_JAZZ, flight.getPrice(), flight.getDepartureTime(), flight.getArrivalTime()))
                .collect(Collectors.toList()));

        flightResults.addAll(completableAirMoonFlights.join().stream()
                .map(flight ->
                        new Flight(Provider.AIR_MOON, flight.getPrice(), flight.getDepartureTime(), flight.getArrivalTime()))
                .collect(Collectors.toList()));

        return flightResults.stream()
                .sorted(Comparator.comparingDouble(Flight::getPrice))
                .limit(config.getPagesize())
                .collect(Collectors.toList());
    }
}
