package com.tripadvisor.integration.controller;

import com.tripadvisor.integration.model.*;
import com.tripadvisor.integration.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping(value ="/bbbb")
    public ModelAndView getAllAirport(){
        ModelAndView mdv=new ModelAndView();
        //ResponseEntity<List<Airport>> airlines = restTemplate.exchange(flight_service_url+"/api/origins", HttpMethod.GET, null, new ParameterizedTypeReference<List<Airport>>(){});
        mdv.setViewName("home");
        //mdv.addObject("airlines",airlines.getBody());
        return mdv;
    }

    @Autowired
    private IBookingService bookingService;

    @GetMapping("home")
    public String index(){
        return  "index";
    }

    @GetMapping
    public ModelAndView index(@ModelAttribute("booking") Booking booking, Model model) {

        if (!model.containsAttribute("booking")) {
            model.addAttribute("booking", booking);
        }
        model.addAttribute("origins", bookingService.getOrigins());
        model.addAttribute("destinations", bookingService.getDestinations(booking.getOriginId()));

        ModelAndView mdv=new ModelAndView();
        //ResponseEntity<List<Airport>> airlines = restTemplate.exchange(flight_service_url+"/api/origins", HttpMethod.GET, null, new ParameterizedTypeReference<List<Airport>>(){});
        mdv.setViewName("home");
        //mdv.addObject("airlines",airlines.getBody());
        return mdv;
       // return "home";
    }

    @PostMapping
    public String reload(Booking booking, RedirectAttributes flash) {
        flash.addFlashAttribute("booking", booking);
        return "redirect:/home";
    }

    @PostMapping("/search")
    public String search(@Valid Booking booking, BindingResult result, RedirectAttributes flash) {

        flash.addFlashAttribute("booking", booking);
        List<String> errors = new ArrayList<>();

        if (result.hasErrors()) {

            for (ObjectError error : result.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
                errors.add(error.getDefaultMessage());
            }

            flash.addFlashAttribute("errors", errors);

            return "redirect:/home";

        } else if (booking.getFrom().compareTo(booking.getTo()) >= 0) {

            errors.add("Departure date must greater than return date");
            flash.addFlashAttribute("errors", errors);

            return "redirect:/home";
        }

        return "redirect:/flights";
    }

    @GetMapping("/flights")
    public String flights(
            @Valid @ModelAttribute("booking") Booking booking, BindingResult result, Model model)
    //@ModelAttribute("booking") Booking booking, Model model)
    {
        if (model.containsAttribute("booking") && result.hasErrors() == false) {
            // System.out.println("booking : " + booking);
            List<Flight> flights = bookingService.getFlights(booking);

            // System.out.println(flights);
            model.addAttribute("flights", flights);

        } else {
            return "redirect:/home";
        }

        return "flights";
    }

    @PostMapping("/book/{id}")
    public String book(@PathVariable Long id, RedirectAttributes flash) {

        if (id != null) {
            return "redirect:/restaurants/" + id;
        }

        return "redirect:/flights";
    }

    @GetMapping("/restaurants/{flightId}")
    public String restaurants(@PathVariable Long flightId, Model model) {
        if (flightId == null) {
            return "redirect:/home";
        }

        List<Restaurant> restaurants = bookingService.getRestaurants(flightId);
        model.addAttribute("restaurants", restaurants);

        return "restaurants";
    }

}
