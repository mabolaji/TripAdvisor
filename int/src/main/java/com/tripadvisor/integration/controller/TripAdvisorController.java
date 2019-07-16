package com.tripadvisor.integration.controller;

import com.tripadvisor.integration.model.Airlines;
import com.tripadvisor.integration.model.Flight;
import com.tripadvisor.integration.model.Hotel;
import com.tripadvisor.integration.model.RentalCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Controller
@RequestMapping("/tripadvisor")
//@Component
public class TripAdvisorController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;
    private String airline_service_url = "http://flight-service/airlines/getairline";
    private String hotel_service_url = "http://hotel-service/hotel-res/allhotels";
    private String car_service_url = "http://car-service/carRental/company";

    @GetMapping(value = "/home")
    public String home()
    {
        return "index";
    }


    @GetMapping(value ="/getairline")
    public String getAllAirlines(Model model){
        ResponseEntity<List<Airlines>> airlines = restTemplate.exchange(airline_service_url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Airlines>>(){});
model.addAttribute("airline",airlines.getBody());
       return "test1";
    }
    @GetMapping(value ="/getcarCompany")
    public List<RentalCompany> getAllCarCompanies(){
        ResponseEntity<List<RentalCompany>> companies = restTemplate.exchange(car_service_url, HttpMethod.GET, null, new ParameterizedTypeReference<List<RentalCompany>>(){});

        return  companies.getBody();
    }


}
