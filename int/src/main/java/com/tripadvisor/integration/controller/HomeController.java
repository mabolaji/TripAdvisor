package com.tripadvisor.integration.controller;

import com.tripadvisor.integration.model.Booking;
import com.tripadvisor.integration.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private IBookingService bookingService;

    @GetMapping
    public String index(@ModelAttribute("booking") Booking booking, Model model) {

        if (!model.containsAttribute("booking")) {
            model.addAttribute("booking", booking);
        }
        model.addAttribute("origins", bookingService.getOrigins());
        model.addAttribute("destinations", bookingService.getDestinations(booking.getOriginId()));


        return "home";
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
        if (model.containsAttribute("booking") && result.hasErrors()==false ) {
            System.out.println("booking : " + booking);
            model.addAttribute("flights", bookingService.getFlights(booking));
        } else {
            return "redirect:/home";
        }

        return "flights";
    }

}
