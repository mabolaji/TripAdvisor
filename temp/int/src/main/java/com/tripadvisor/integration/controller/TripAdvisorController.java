package com.tripadvisor.integration.controller;

import com.tripadvisor.integration.model.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Controller
//@RequestMapping("/trip")
public class TripAdvisorController {

    private static final String EXCHANGE = "travel_advisory";
    private static final String ROUTING_KEY = "flight_booking_queue";

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    private String flight_service_url = "http://flight1-service/";
    private String hotel_service_url = "http://hotel-service/";
    private String car_service_url = "http://car-service/carRental/company";

    @GetMapping(value ="/getairline")
    public List<Airlines> getAllAirlines(){
        ResponseEntity<List<Airlines>> airlines = restTemplate.exchange(flight_service_url+"/api/getAirlines", HttpMethod.GET, null, new ParameterizedTypeReference<List<Airlines>>(){});

        return airlines.getBody();
    }

    @GetMapping(value ="/getAirports")
    public ModelAndView getAllAirport(){
        ModelAndView mdv=new ModelAndView();
        ResponseEntity<List<Airport>> airlines = restTemplate.exchange(flight_service_url+"/api/origins", HttpMethod.GET, null, new ParameterizedTypeReference<List<Airport>>(){});
        mdv.setViewName("index");
        mdv.addObject("airlines",airlines.getBody());
        return mdv;
    }

    @GetMapping("/home")
    public String home(){
        return "flights";
    }

    @GetMapping(value ="/getcarCompany")
    public List<RentalCompany> getAllCarCompanies(){
        ResponseEntity<List<RentalCompany>> companies = restTemplate.exchange(car_service_url, HttpMethod.GET, null, new ParameterizedTypeReference<List<RentalCompany>>(){});

        return  companies.getBody();
    }


    @PostMapping(value = "/searchFlight")
    public String searchFlight(@RequestParam String departure, @RequestParam String arrival, @RequestParam  String departureDate,Model model)
    {
        List<FlightDto> flights = (restTemplate.exchange(flight_service_url + "api/flightFilter?departure="+departure+"&arrival="+arrival+"&departureDate="+departureDate, HttpMethod.GET, null, new ParameterizedTypeReference<List<FlightDto>>(){})).getBody();
        model.addAttribute("flightlist",flights);
        return "flights";
    }

    @PostMapping(value = "/book")
    public String book(@RequestParam String email,@RequestParam Long id)
    {
        System.out.println(id);
        FlightBook flights = (restTemplate.exchange(flight_service_url + "/api/book?email="+email+"&id="+id, HttpMethod.POST, null, new ParameterizedTypeReference<FlightBook>(){})).getBody();

        BookingDto msg =  new BookingDto();
        msg.setEmail(email);
        msg.setFlightId(id);
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, msg);

        return "test";
    }
    @GetMapping(value = "/destination/{destination}")
    public List<Airport> destination(@PathVariable String destination)
    {

        List<Airport> airports = (restTemplate.exchange(flight_service_url + "flight/destination/"+destination, HttpMethod.GET, null, new ParameterizedTypeReference<List<Airport>>() {
        }).getBody());

//        http://localhost:8081/flight/all?departure=4&arrival=7&departureDate=2019-07-22&arrivalDate=2019-07-23
        return  airports;
    }

}
