package com.vlstr.bcmbackend.provider;

import com.vlstr.bcmbackend.AppConfiguration;
import com.vlstr.bcmbackend.util.HttpHelper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AirBeamProvider {

    private final AppConfiguration config;
    private final HttpHelper httpHelper;

    public AirBeamProvider(AppConfiguration config, HttpHelper httpHelper) {
        this.config = config;
        this.httpHelper = httpHelper;
    }

    public ResponseEntity<Void[]> getFlights() {
        // Not implemented now
        // TODO: Get CSV from HTTP and map csv to POJO
        return ResponseEntity.of(Optional.empty());
    }
}
