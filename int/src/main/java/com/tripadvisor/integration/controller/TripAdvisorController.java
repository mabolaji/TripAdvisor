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
@SessionAttributes({"arrival","cityid"})
public class TripAdvisorController {

    private static final String EXCHANGE = "travel_advisory";
    private static final String ROUTING_KEY = "flight_booking_queue";

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    private String flight_service_url = "http://flight-service/";
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

   /* @GetMapping("/home")
    public String home(){
        return "flights";
    }*/

    @GetMapping(value ="/getcarCompany")
    public List<RentalCompany> getAllCarCompanies(){
        ResponseEntity<List<RentalCompany>> companies = restTemplate.exchange(car_service_url, HttpMethod.GET, null, new ParameterizedTypeReference<List<RentalCompany>>(){});

        return  companies.getBody();
    }


    @PostMapping(value = "/searchFlight")
    public String searchFlight(@RequestParam String departure, @RequestParam String arrival, @RequestParam  String departureDate,Model model)
    {
        List<FlightDto> flights = (restTemplate.exchange(flight_service_url + "api/flightFilter?departure="+departure+"&arrival="+arrival+"&departureDate="+departureDate, HttpMethod.GET, null, new ParameterizedTypeReference<List<FlightDto>>(){})).getBody();
//        List<Hotel> hotels =  (restTemplate.exchange(hotel_service_url + "api/hotles?city="+arrival, HttpMethod.GET, null, new ParameterizedTypeReference<List<Hotel>>(){})).getBody();
        model.addAttribute("arrival",arrival);
        model.addAttribute("flightlist",flights);
        return "flightlist";
    }

    @PostMapping(value = "/book")
    public String book(@RequestParam String email,@RequestParam Long id,Model model)
    {
        System.out.println();
        model.addAttribute("cityid",id);
        BookingDto msg =  new BookingDto();
        msg.setEmail(email);
        msg.setFlightId(id);
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, msg);
        return "redirect:/hotels";
    }
    @GetMapping(value = "/destination/{destination}")
    public List<Airport> destination(@PathVariable String destination)
    {

        List<Airport> airports = (restTemplate.exchange(flight_service_url + "flight/destination/"+destination, HttpMethod.GET, null, new ParameterizedTypeReference<List<Airport>>() {
        }).getBody());

        return  airports;
    }

}
