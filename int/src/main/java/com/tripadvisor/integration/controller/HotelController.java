
package com.tripadvisor.integration.controller;

import com.tripadvisor.integration.model.Airport;
import com.tripadvisor.integration.model.Hotel;
import com.tripadvisor.integration.model.HotelBooking;
import com.tripadvisor.integration.service.FlightService;
import com.tripadvisor.integration.service.HotelService;
import com.tripadvisor.integration.util.Common;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HotelController {
    private static final String ROUTING_KEY = "hotel_booking_queue";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    HotelService hotelService;
    @Autowired
    FlightService flightService;

    @GetMapping("/hotels")
    public String hotels(Model model, HttpSession httpSession, String hotel) {
        try {
            Airport city = flightService.city(httpSession.getAttribute("arrival").toString());
            List<Hotel> hotelList = hotelService.findbycity(city.getCity());
            //List<Room> rooms=hotelService.rooms();
//        System.out.println("from hotel roommmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm "+hotelList.size());
            System.out.println(hotelList);
            for (Hotel h : hotelList) {
                System.out.println(h.getRoooms());
            }
            model.addAttribute("hotelsbycity", hotelList);
            return "hotelbycity";
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return "redirect:/home";
        }
    }

    @GetMapping("/room")
    public String flight() {
        return "test";
    }

    @PostMapping(value = "/hotels")
    public String cars(@Valid HotelBooking booking, BindingResult bindingResult, RedirectAttributes flash) {


        if (bindingResult.hasErrors()) {
            List<String> errors = new ArrayList<>();
            for (ObjectError error : bindingResult.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
                errors.add(error.getDefaultMessage());

                flash.addFlashAttribute("errors", errors);
            }
            return "redirect:/hotels";
        } else {
            System.out.println(booking);
            rabbitTemplate.convertAndSend(Common.EXCHANGE, ROUTING_KEY, booking);
            return "redirect:/cars";
        }

    }
}

