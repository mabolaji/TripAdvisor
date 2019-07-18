package com.project.tripadvisor.hotelres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class HotelResApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelResApplication.class, args);
    }

}
