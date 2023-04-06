package com.javawebhw.travel_agency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class TravelAgencyApplication {

	@RequestMapping("/")
	String home() {
		return "Hello world!";
	}
	public static void main(String[] args) {
		SpringApplication.run(TravelAgencyApplication.class, args);
	}

}
