package com.tripadvisor.integration.controller;

import com.tripadvisor.integration.model.Hotel;
import com.tripadvisor.integration.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class HotelController {
    @Autowired
    HotelService hotelService;
    @GetMapping("/hotels")
    public String  hotels(){
        return "cars";
    }

    @GetMapping("/flights")
    public String  flight(){
        return "fights";
    }
}
