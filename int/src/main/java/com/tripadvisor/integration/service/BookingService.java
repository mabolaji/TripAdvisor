package com.tripadvisor.integration.service;

import com.tripadvisor.integration.model.Airport;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService implements IBookingService {
    @Override
    public List<Airport> getOrigins() {
        List<Airport> airports = new ArrayList<>();
        for (Long i = 0l; i < 5; i++) {
            Airport airport = new Airport();
            airport.setId(i);
            airport.setName("airport " + i);
            airports.add(airport);
        }

        return airports;
    }

    @Override
    public List<Airport> getDestinations(Long originId) {
        List<Airport> airports = new ArrayList<>();

        if (originId != null) {

            for (Long i = originId; i <= 5; i++) {
                Airport airport = new Airport();
                airport.setId(i);
                airport.setName("destination " + i);
                airports.add(airport);
            }
        }
        return airports;
    }

}
