package com.javawebhw.travel_agency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class TravelAgencyApplication {
	public static void main(String[] args) {
		SpringApplication.run(TravelAgencyApplication.class, args);
	}

}
