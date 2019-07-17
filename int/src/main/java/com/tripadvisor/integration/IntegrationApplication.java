package com.tripadvisor.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
=======
>>>>>>> master
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class IntegrationApplication {

<<<<<<< HEAD

=======
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
>>>>>>> master
    public static void main(String[] args) {
        SpringApplication.run(IntegrationApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
