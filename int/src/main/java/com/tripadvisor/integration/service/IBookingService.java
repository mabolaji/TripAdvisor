package com.tripadvisor.integration.service;

import com.tripadvisor.integration.model.*;

import java.util.List;

public interface IBookingService {
    List<Airport> getOrigins();
    List<Airport> getDestinations(Long originId);
    List<FlightDto> getFlights(Booking booking);
    List<Restaurant> getRestaurants(Long flightId);
}
