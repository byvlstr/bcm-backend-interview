package com.vlstr.bcmbackend;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
public class AppConfiguration {

    private Mockaroo mockaroo;
    private Api api;
    private int pagesize;

    public Mockaroo getMockaroo() {
        return mockaroo;
    }

    public void setMockaroo(Mockaroo mockaroo) {
        this.mockaroo = mockaroo;
    }

    public Api getApi() {
        return api;
    }

    public void setApi(Api api) {
        this.api = api;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public static class Mockaroo {
        private String api_key;
        private String url;

        public String getApi_key() {
            return api_key;
        }

        public void setApi_key(String api_key) {
            this.api_key = api_key;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class Api {
        private String airJazz;
        private String airMoon;
        private String airBeam;

        public String getAirJazz() {
            return airJazz;
        }

        public void setAirJazz(String airJazz) {
            this.airJazz = airJazz;
        }

        public String getAirMoon() {
            return airMoon;
        }

        public void setAirMoon(String airMoon) {
            this.airMoon = airMoon;
        }

        public String getAirBeam() {
            return airBeam;
        }

        public void setAirBeam(String airBeam) {
            this.airBeam = airBeam;
        }
    }
}
