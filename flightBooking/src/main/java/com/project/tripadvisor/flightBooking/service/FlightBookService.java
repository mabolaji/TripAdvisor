package com.project.tripadvisor.flightBooking.service;

import com.project.tripadvisor.flightBooking.model.Flight;
import com.project.tripadvisor.flightBooking.model.FlightBook;

import java.time.LocalDate;
import java.util.List;

public interface FlightBookService {

    List<Flight> flightes(String departure, String arrival, LocalDate departureDate, LocalDate arrivalDate);

    FlightBook bookFlight(String email, Flight flight);

    FlightBook bookFlight(String email, Long flightId);

}
