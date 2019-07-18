package com.tripadvisor.integration.controller;


import com.tripadvisor.integration.model.*;
import com.tripadvisor.integration.service.IBookingService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
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
//import org.springframework.web.reactive.function.client.WebClient;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("/home")
public class HomeController {

    @Autowired
    private IBookingService bookingService;

    @GetMapping(value = "/")
    public String index() {
        return "redirect:/home";
    }
    @GetMapping(value = "/home")
    public String home(@ModelAttribute("booking") Booking booking, Model model) {

        if (!model.containsAttribute("booking")) {
            model.addAttribute("booking", booking);
        }
        if (!model.containsAttribute("errors")) {
            model.addAttribute("errors",  null);
        }
        model.addAttribute("origins", bookingService.getOrigins());
        model.addAttribute("destinations", bookingService.getDestinations(booking.getOriginId()));
        return "home";

         /*
        ModelAndView mdv=new ModelAndView();
        //ResponseEntity<List<Airport>> airlines = restTemplate.exchange(flight_service_url+"/api/origins", HttpMethod.GET, null, new ParameterizedTypeReference<List<Airport>>(){});
        mdv.setViewName("home");
        //mdv.addObject("airlines",airlines.getBody());
        return mdv;
        //

        ModelAndView mdv = new ModelAndView();
        //ResponseEntity<List<Airport>> airlines = restTemplate.exchange(flight_service_url+"/api/origins", HttpMethod.GET, null, new ParameterizedTypeReference<List<Airport>>(){});
        mdv.setViewName("home");
        mdv.addObject("airlines", bookingService.getOrigins());
        return mdv;*/
    }

    @PostMapping(value = "/home")
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
    public String flights(@Valid @ModelAttribute("booking") Booking booking, BindingResult result, Model model)
    {
        if (model.containsAttribute("booking") && result.hasErrors() == false) {
            List<FlightDto> flights = bookingService.getFlights(booking);

            model.addAttribute("flights", flights);

        } else {
            return "redirect:/home";
        }

        return "flights";
    }
}
