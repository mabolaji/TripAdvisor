package com.tripadvisor.integration.controller;

import com.tripadvisor.integration.model.Airlines;
import com.tripadvisor.integration.model.Airport;
import com.tripadvisor.integration.model.Flight;
import com.tripadvisor.integration.model.RentalCompany;
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

    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
//    private WebClient.Builder webClientBuilder;
//    private String airline_service_url = "http://flight-service/airlines/getairline";
//    private String hotel_service_url = "http://hotel-service/hotel-res/allhotels";
//    private String car_service_url = "http://car-service/carRental/company";
//
//    @GetMapping(value = "/home")
//    public String home() {
//        return "index";
//    }
//
//
//    @GetMapping(value = "/getairline")
//    public String getAllAirlines(Model model) {
//        ResponseEntity<List<Airlines>> airlines = restTemplate.exchange(airline_service_url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Airlines>>() {
//        });
//        model.addAttribute("airline", airlines.getBody());
//        return "test1";
//    }
//
//    @GetMapping(value = "/getcarCompany")
//    public List<RentalCompany> getAllCarCompanies() {
//        ResponseEntity<List<RentalCompany>> companies = restTemplate.exchange(car_service_url, HttpMethod.GET, null, new ParameterizedTypeReference<List<RentalCompany>>() {
//        });
//
//        return companies.getBody();    }
//@Autowired
//private WebClient.Builder webClientBuilder;
    private String flight_service_url = "http://flight1-service/";
    private String hotel_service_url = "http://hotel-service/hotel-res/allhotels";
    private String car_service_url = "http://car-service/carRental/company";


//    @GetMapping(value = "/home")
//    public String home()
//    {
//        return "index";
//    }


    @GetMapping(value ="/getairline")
    public List<Airlines> getAllAirlines(){
        ResponseEntity<List<Airlines>> airlines = restTemplate.exchange(flight_service_url+"/api/getAirlines", HttpMethod.GET, null, new ParameterizedTypeReference<List<Airlines>>(){});
//model.addAttribute("airline",airlines.getBody());
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
        return "index";
    }

    @GetMapping(value ="/getcarCompany")
    public List<RentalCompany> getAllCarCompanies(){
        ResponseEntity<List<RentalCompany>> companies = restTemplate.exchange(car_service_url, HttpMethod.GET, null, new ParameterizedTypeReference<List<RentalCompany>>(){});

        return  companies.getBody();
    }


    @GetMapping(value = "/searchFlight")
    public List<Flight> searchFlight(@RequestParam String departure, @RequestParam String arrival, @RequestParam  String departureDate)
    {
        List<Flight> flights = (restTemplate.exchange(flight_service_url + "flight/flightFilter?departure="+departure+"&arrival="+arrival+"&departureDate="+departureDate, HttpMethod.GET, null, new ParameterizedTypeReference<List<Flight>>() {
        }).getBody());

//        http://localhost:8081/flight/all?departure=4&arrival=7&departureDate=2019-07-22&arrivalDate=2019-07-23
        return  flights;
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
