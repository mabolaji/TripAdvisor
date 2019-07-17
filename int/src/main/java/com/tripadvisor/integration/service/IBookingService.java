package com.tripadvisor.integration.service;

import com.tripadvisor.integration.model.Airport;
import com.tripadvisor.integration.model.Booking;
import com.tripadvisor.integration.model.Flight;
import com.tripadvisor.integration.model.Restaurant;

import java.util.List;

public interface IBookingService {
    List<Airport> getOrigins();
    List<Airport> getDestinations(Long originId);
    List<Flight> getFlights(Booking booking);
    List<Restaurant> getRestaurants(Long flightId);
}
