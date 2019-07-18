package com.tripadvisor.integration.service;

import com.tripadvisor.integration.model.Airport;
import com.tripadvisor.integration.model.Hotel;
import com.tripadvisor.integration.util.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FlightProxyService implements  FlightService {
    @Autowired
    private RestTemplate restTemplate;


    @Override
    public Airport city(String id) {

        Airport response =
                restTemplate.exchange(Common.flight_search_url+"/citybyid?id="+id, HttpMethod.GET, null,
                        new ParameterizedTypeReference<Airport>(){}).getBody();

        return response;
    }
}
