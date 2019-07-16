package com.tripadvisor.integration.controller;

import com.tripadvisor.integration.model.Airport;
import com.tripadvisor.integration.model.Booking;
import com.tripadvisor.integration.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private IBookingService bookingService;
    @GetMapping
    public String index(@ModelAttribute("booking") @Valid Booking booking, Model model) {


        model.addAttribute("origins",  bookingService.getOrigins());
        model.addAttribute("destinations",  bookingService.getDestinations(booking.getOriginId()));


        if (!model.containsAttribute("booking")) {
            model.addAttribute("booking", booking);
            System.out.println(booking);
        }
        else{
            System.out.println("booking exists");
        }
        return "home";
    }

    @PostMapping
    public String reload(Booking booking, RedirectAttributes flash) {

        flash.addFlashAttribute("booking", booking);
        //System.out.println(booking);
        System.out.println(flash.getFlashAttributes().keySet());
        return "redirect:/home";
    }

    @GetMapping("/temp")
    public String testpage(){
        return "test";
    }

}
