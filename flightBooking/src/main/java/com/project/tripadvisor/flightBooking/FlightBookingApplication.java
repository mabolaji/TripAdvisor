package com.project.tripadvisor.flightBooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
//@EnableEurekaClient
public class FlightBookingApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightBookingApplication.class, args);
    }
    //    @Bean
//    public WebClient.Builder getWebClientBuilder()
//    {
//        return  WebClient.builder();
//    }
 /*   @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
//        return new RestTemplate();


//        return new RestTemplate();
        final RestTemplate restTemplate = new RestTemplate();

        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);
        return restTemplate;
    }*/

}