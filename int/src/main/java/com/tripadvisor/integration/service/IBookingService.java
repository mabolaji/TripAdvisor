package com.tripadvisor.integration.service;

import com.tripadvisor.integration.model.Airport;

import java.util.List;

public interface IBookingService {
    List<Airport> getOrigins();
    List<Airport> getDestinations(Long originId);
}
