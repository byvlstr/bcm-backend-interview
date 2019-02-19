package com.vlstr.bcmbackend.controller;

import com.vlstr.bcmbackend.domain.Flight;
import com.vlstr.bcmbackend.service.FlightService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/flights")
    public ResponseEntity<List<Flight>> getFlights() {
        return ResponseEntity.ok(flightService.getFlights());
    }
}
