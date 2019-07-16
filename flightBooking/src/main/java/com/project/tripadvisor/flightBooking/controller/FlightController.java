package com.project.tripadvisor.flightBooking.controller;

import com.project.tripadvisor.flightBooking.dao.FlightRepository;
import com.project.tripadvisor.flightBooking.model.Airport;
import com.project.tripadvisor.flightBooking.model.Flight;
import com.project.tripadvisor.flightBooking.model.FlightBook;
import com.project.tripadvisor.flightBooking.service.FlightBookService;
import com.project.tripadvisor.flightBooking.service.serviceImpl.AirportServiceImpl;
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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class FlightController {
    @Autowired
    private FlightBookServiceImpl flightBookService;

    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private AirportServiceImpl airportService;

    @GetMapping("/flights")
    public List<Flight> flights(@RequestParam String departure, @RequestParam String arrival, @RequestParam  String departureDate, @RequestParam  String arrivalDate)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate arrivalDate1 = LocalDate.parse(arrivalDate, formatter);
        LocalDate departureDate1 = LocalDate.parse(departureDate, formatter);
        List<Flight> flights=  flightBookService.flightes(Long.parseLong(departure),Long.parseLong(arrival),departureDate1,arrivalDate1);
        return flights;
    }
    @GetMapping("/flightFilter")
    public List<Flight> flightFilter(@RequestParam String departure, @RequestParam String arrival, @RequestParam  String departureDate)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate departureDate1 = LocalDate.parse(departureDate, formatter);
        List<Flight> flights=  flightBookService.flightesFilter(Long.parseLong(departure),Long.parseLong(arrival),departureDate1);
        return flights;
    }


    @GetMapping("/test")
    public List<Flight> flights()
    {
        return  flightRepository.findAll();
    }

    @GetMapping("/test111")
    public  List<Flight> test(@RequestParam String arrival,@RequestParam String departure)
    {
        return flightBookService.test(arrival,departure);
    }
    @PostMapping("/book")
    public FlightBook bookFlight(@RequestParam String email, @RequestBody Flight flight)
    {
        return flightBookService.bookFlight(email,flight);
    }

    @GetMapping(value = "/origins")
    public List<Airport> getAirports()
    {
        return  airportService.getOrigin();
    }

    @GetMapping("/destination")
public List<Airport> getAirportsDest(@RequestParam String departure){
        return flightBookService.departureFlight(Long.parseLong(departure));//.stream().map(f->f.getArrival()).collect(Collectors.toList());
    }



}
