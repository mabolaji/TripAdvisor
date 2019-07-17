package com.project.tripadvisor.flightBooking.service;

import com.project.tripadvisor.flightBooking.model.Airport;

import java.util.List;

public interface AirlinesService {
    public Airport add(Airport airlines);
    public List<Airport> getAirlines();

    public void delete(Long id);
}
