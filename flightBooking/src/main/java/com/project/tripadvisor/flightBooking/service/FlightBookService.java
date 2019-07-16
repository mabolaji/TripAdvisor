package com.project.tripadvisor.flightBooking.service;

import com.project.tripadvisor.flightBooking.model.Flight;
import com.project.tripadvisor.flightBooking.model.FlightBook;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface FlightBookService {

    public List<Flight> flightes(String departure, String arrival, LocalDate departureDate, LocalDate arrivalDate);

    public FlightBook bookFlight(String email, Flight flight);
    public  List<Flight> flightesFilter(String departure, String arrival, LocalDate departureDate);
    public List<Flight> departureFlight(String departure);

}
