package com.project.tripadvisor.flightBooking.controller;

import com.project.tripadvisor.flightBooking.dao.AirlinesRepository;
import com.project.tripadvisor.flightBooking.dao.AirportRepository;
import com.project.tripadvisor.flightBooking.dao.FlightRepository;
import com.project.tripadvisor.flightBooking.model.*;
import com.project.tripadvisor.flightBooking.service.serviceImpl.AirportServiceImpl;
import com.project.tripadvisor.flightBooking.service.serviceImpl.FlightBookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
    private AirlinesRepository airlines;
    @Autowired
    private AirportServiceImpl airportService;

    @Autowired
    private AirportRepository airportRepository;

    @GetMapping("/getAirlines")
    public List<Airlines> getAirlines() {
        return airlines.findAll();
    }


    @GetMapping("/flights")
    public List<Flight> flights(@RequestParam String departure, @RequestParam String arrival, @RequestParam String departureDate, @RequestParam String arrivalDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate arrivalDate1 = LocalDate.parse(arrivalDate, formatter);
        LocalDate departureDate1 = LocalDate.parse(departureDate, formatter);
        List<Flight> flights = flightBookService.flightes(Long.parseLong(departure), Long.parseLong(arrival), departureDate1, arrivalDate1);
        return flights;
    }

    @GetMapping("/flightFilter")
    public List<FlightDto> flightFilter(@RequestParam String departure, @RequestParam String arrival, @RequestParam String departureDate) throws ParseException {

        String newDate = departureDate.replaceAll("(\\d+)/(\\d+)/(\\d+)", "$3-$1-$2");
        System.out.println("after formating " + newDate);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate departureDate1 = LocalDate.parse(newDate, formatter);

        List<Flight> flights = flightBookService.flightesFilter(Long.parseLong(departure), Long.parseLong(arrival), departureDate1);

        List<FlightDto> list = new ArrayList<>();
        flights
                .stream()
                .forEach(f -> {
                    FlightDto data = new FlightDto();
                    data.setFlightNumber(f.getFlightNumber());
                    data.setAirLine(f.getAirplane().getAirline().getName());
                    data.setArrival_city(f.getArrival().getCity());
                    data.setId(f.getId());
                    data.setArrival_city(f.getArrival().getCity());
                    data.setArrival_date(f.getArrivalDate().toLocalDate());
                    data.setDeparture_date(f.getDepartureDate().toLocalDate());
                    data.setReg_num(f.getAirplane().getRegestrationNo());
                    data.setDeparture_city(f.getDeparture().getCity());
                    data.setDepartureTime(f.getDepartureDate().toLocalTime());
                    data.setArrivalTime(f.getArrivalDate().toLocalTime());
                    list.add(data);
                });

        return list;
//        System.out.println(flights.get(0)+" after change");
        //  return flights;
    }

    @GetMapping("/city")
    public Airport city(@RequestParam String departure) {
        return airportRepository.findById(Long.parseLong(departure)).get();
    }

//    @GetMapping("/citybyid")
//    public String citybyid(@RequestParam String id)
//    {
//
//        String t= airportRepository.findById(Long.parseLong(id)).get().getCity();
//        System.out.println("from flight "+t);
//        return t;
//    }


    @GetMapping("/citybyid")
    public Airport citybyid(@RequestParam String id)
    {

        Airport t= airportRepository.findById(Long.parseLong(id)).get();
        System.out.println("from flight "+t);
        return t;
    }


    @GetMapping("/flightFilterOptional")
    public List<Flight> flightFilteroptional(@RequestParam String departure, @RequestParam String arrival, @RequestParam String departureDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        List<Flight> flights = new ArrayList<>();
        if (departure.isEmpty() && arrival.isEmpty() && departureDate.isEmpty()) {
            flights = flightBookService.ActualFight();
        } else if (departure.isEmpty() && departureDate.isEmpty()) {
            flights = flightBookService.ActualFight().stream().filter(f -> f.getArrival().getId().equals(Long.parseLong(arrival))).collect(Collectors.toList());
        } else if (arrival.isEmpty() && departureDate.isEmpty()) {
            flights = flightBookService.ActualFight().stream().filter(f -> f.getDeparture().getId().equals(Long.parseLong(departure))).collect(Collectors.toList());
            ;
        } else if (arrival.isEmpty() && departure.isEmpty()) {
            LocalDate departureDate1 = LocalDate.parse(departureDate, formatter);
            flights = flightBookService.ActualFight().stream().filter(f -> f.getDepartureDate().toLocalDate().isEqual(departureDate1)).collect(Collectors.toList());
        } else {

            LocalDate departureDate1 = LocalDate.parse(departureDate, formatter);
            flights = flightBookService.flightesFilter(Long.parseLong(departure), Long.parseLong(arrival), departureDate1);

        }

        return flights;
    }

    @GetMapping("/test")
    public List<Flight> flights() {
        return flightRepository.findAll();
    }

    @GetMapping("/test111")
    public List<Flight> test(@RequestParam String arrival, @RequestParam String departure) {
        return flightBookService.test(arrival, departure);
    }
    @PostMapping("/book")
    public FlightBook bookFlight(@RequestParam String email, @RequestParam String id)
    {
        System.out.println("testtttttttt "+email +" "+id);

        Flight flight=flightRepository.findById(Long.parseLong(id)).get();
        System.out.println(flight.getDepartureDate()+"testtttttttttttt");
        return flightBookService.bookFlight(email,flight);
    }
    @GetMapping(value = "/origins")
    public List<Airport> getAirports() {
        return airportService.getOrigin();
    }

    @GetMapping("/destination")
    public List<Airport> getAirportsDest(@RequestParam String departure) {
        return flightBookService.departureFlight(Long.parseLong(departure));//.stream().map(f->f.getArrival()).collect(Collectors.toList());
    }


}
