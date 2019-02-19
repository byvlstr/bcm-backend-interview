package com.vlstr.bcmbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class BcmBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BcmBackendApplication.class, args);
	}

}

