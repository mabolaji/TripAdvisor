package com.tripadvisor.integration.service;

import com.tripadvisor.integration.model.Airport;

import java.util.ArrayList;
import java.util.List;

public class BookingService  implements  IBooking{
    @Override
    public List<Airport> getOrigings() {
        List<Airport> airports =  new ArrayList<>();
        airports.add(new Airport(){});
        return null;
    }
}
