package com.tripadvisor.integration.controller;


import com.tripadvisor.integration.model.Booking;
import com.tripadvisor.integration.model.BookingDto;
import com.tripadvisor.integration.model.FlightDto;
import com.tripadvisor.integration.service.IBookingService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

//import org.springframework.web.reactive.function.client.WebClient;

@Controller
@SessionAttributes("arrival")
public class HomeController {

    @Autowired
    private IBookingService bookingService;

    private static final String EXCHANGE = "travel_advisory";
    private static final String ROUTING_KEY = "flight_booking_queue";
    @Autowired
    private RabbitTemplate rabbitTemplate;

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
            model.addAttribute("errors", null);
        }
        model.addAttribute("origins", bookingService.getOrigins());
        model.addAttribute("destinations", bookingService.getDestinations(booking.getOriginId()));
        return "home";

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

        flash.addAttribute("arrival",booking.getDestinationId());

        if (result.hasErrors()) {

            for (ObjectError error : result.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
                errors.add(error.getDefaultMessage());
            }

            flash.addFlashAttribute("errors", errors);

            return "redirect:/home";
        }
        /*} else if (booking.getFrom().compareTo(booking.getTo()) >= 0) {

            errors.add("Departure date must greater than return date");
            flash.addFlashAttribute("errors", errors);

            return "redirect:/home";
        }*/

        return "redirect:/flights";
    }

    @GetMapping("/flights")
    public String flights(@Valid @ModelAttribute("booking") Booking booking, BindingResult result, Model model) {
        if (model.containsAttribute("booking") && result.hasErrors() == false) {
            List<FlightDto> flights = bookingService.getFlights(booking);

            System.out.println(flights);

            model.addAttribute("flights", flights);

        } else {
            return "redirect:/home";
        }

        return "flights";
    }

    @PostMapping("/bookflight")
    public String book(@RequestParam String email,@RequestParam Long id)
    {
        if (id != null) {

            BookingDto msg = new BookingDto();
            msg.setEmail(email);
            msg.setFlightId(id);
            rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, msg);

            return "redirect:/cars";
        }

        return "redirect:/flights";
    }
}
