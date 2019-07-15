package com.project.tripadvisor.flightBooking.controller;

import com.project.tripadvisor.flightBooking.model.Flight;
import com.project.tripadvisor.flightBooking.model.FlightBook;
import com.project.tripadvisor.flightBooking.service.FlightBookService;
import com.project.tripadvisor.flightBooking.service.serviceImpl.FlightBookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/flight")
public class BookFlightController {
    @Autowired
    private FlightBookServiceImpl flightBookService;

    @GetMapping("/all")
    public List<Flight> flightes(@RequestParam String departure, @RequestParam String arrival, @RequestParam  String departureDate, @RequestParam  String arrivalDate)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate arrivalDate1 = LocalDate.parse(arrivalDate, formatter);
        LocalDate departureDate1 = LocalDate.parse(departureDate, formatter);
        List<Flight> flights=  flightBookService.flightes(departure,arrival,departureDate1,arrivalDate1);
        return flights;
    }

    @GetMapping("/test")
    public  List<Flight> test(@RequestParam String arrival,@RequestParam String departure)
    {
        return flightBookService.test(arrival,departure);
    }
    @PostMapping("/book")
    public FlightBook bookFlight(@RequestParam String email, @RequestBody Flight flight)
    {
        return flightBookService.bookFlight(email,flight);
    }


}
