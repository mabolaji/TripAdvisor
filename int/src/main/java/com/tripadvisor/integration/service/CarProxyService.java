package com.tripadvisor.integration.service;

import com.tripadvisor.integration.model.CarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CarProxyService implements CarService {
    @Autowired
    private RestTemplate restTemplate;

    private String car_service_url = "http://car-service";


//    @Override
//    public List<Hotel> findAllHotels() {
////        ResponseEntity<List<Hotel>> response =
////                restTemplate.exchange(hotel_service_url +"/api/allhotels", HttpMethod.GET, null,
////                        new ParameterizedTypeReference<List<Hotel>>() {
////                        });
//
//
//        ResponseEntity<List<Hotel>> response =
//                restTemplate.exchange(hotel_service_url+"/api/allhotels", HttpMethod.GET, null,
//                        new ParameterizedTypeReference<List<Hotel>>(){});
//
//        return response.getBody();
//    }

    @Override
    public List<CarDTO> findCars(String id) {

        ResponseEntity<List<CarDTO>> response =
                restTemplate.exchange(car_service_url+"/api/cars/carsearchByComp?company="+id, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<CarDTO>>(){});

        return response.getBody();
    }




}
