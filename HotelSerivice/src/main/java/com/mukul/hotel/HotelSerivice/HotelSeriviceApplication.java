package com.mukul.hotel.HotelSerivice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HotelSeriviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelSeriviceApplication.class, args);
	}

}
