package com.project.tripadvisor.flightBooking.service;

import com.project.tripadvisor.flightBooking.model.Airport;
import com.project.tripadvisor.flightBooking.model.Flight;
import com.project.tripadvisor.flightBooking.model.FlightBook;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface FlightBookService {

    public List<Flight> flightes(Long departure, Long arrival, LocalDate departureDate, LocalDate arrivalDate);

    public FlightBook bookFlight(String email, Flight flight);
    FlightBook bookFlight(String email, Long flightId);
    public  List<Flight> flightesFilter(Long departure, Long arrival, LocalDate departureDate);
    public List<Airport> departureFlight(Long departure);
    public List<Flight> ActualFight();
}
