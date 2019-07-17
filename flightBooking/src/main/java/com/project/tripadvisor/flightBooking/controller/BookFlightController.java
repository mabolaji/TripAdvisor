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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/flight")
public class BookFlightController {
    @Autowired
    private FlightBookServiceImpl flightBookService;

    @GetMapping("/all")
    public List<Flight> flightes(@RequestParam String departure, @RequestParam String arrival, @RequestParam  String departureDate, @RequestParam  String arrivalDate) throws ParseException {
        Date departureDate1 = new SimpleDateFormat("dd/MM/yyyy").parse(departureDate);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String parsedDate = formatter.format(departureDate1);
        LocalDate departureDaten = LocalDate.parse(parsedDate);

        Date arrivalDate1 = new SimpleDateFormat("dd/MM/yyyy").parse(arrivalDate);
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String parsedDate1 = formatter.format(arrivalDate1);
        LocalDate arrivalDaten = LocalDate.parse(parsedDate1);


        List<Flight> flights=  flightBookService.flightes(Long.parseLong(departure),Long.parseLong(arrival),departureDaten,arrivalDaten);
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
