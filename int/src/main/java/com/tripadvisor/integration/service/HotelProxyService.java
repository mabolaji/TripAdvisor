package com.tripadvisor.integration.service;

import com.tripadvisor.integration.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class HotelProxyService implements HotelService {
    @Autowired
    private RestTemplate restTemplate;

    private final String hotelUrl = "http://localhost:8080/hotel-res/";


    @Override
    public List<Hotel> findAllHotels() {
        ResponseEntity<List<Hotel>> response =
                restTemplate.exchange(hotelUrl +"allhotels", HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Hotel>>() {
                        });
        return response.getBody();
    }
}
