package com.vlstr.bcmbackend.util;

import com.vlstr.bcmbackend.AppConfiguration;
import com.vlstr.bcmbackend.domain.enums.Provider;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class HttpHelper {

    private final AppConfiguration config;

    public HttpHelper(AppConfiguration config) {
        this.config = config;
    }

    public String getFullEndpointUrl(Provider provider) {
        String baseUrl = config.getMockaroo().getUrl();
        switch (provider) {
            case AIR_MOON:
                return baseUrl + config.getApi().getAirMoon();
            case AIR_JAZZ:
                return baseUrl + config.getApi().getAirJazz();
            case AIR_BEAM:
                return baseUrl + config.getApi().getAirBeam();
        }

        return null;
    }

    public HttpEntity<String> getDefaultEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-API-Key", config.getMockaroo().getApi_key());

        return new HttpEntity<>("parameters", headers);
    }
}
