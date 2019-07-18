
package com.tripadvisor.integration.controller;

import com.tripadvisor.integration.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HotelController {
    @Autowired
    HotelService hotelService;
    @GetMapping("/hotels")
    public String  hotels(Model model){
        model.addAttribute("hotels", hotelService.findAllHotels());
        return "hotels";
    }

    @GetMapping("/room")
    public String  flight(){
        return "test";
    }
}

