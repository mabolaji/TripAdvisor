
package com.tripadvisor.integration.controller;

import com.tripadvisor.integration.model.Airport;
import com.tripadvisor.integration.model.Hotel;
import com.tripadvisor.integration.service.FlightService;
import com.tripadvisor.integration.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HotelController {
    @Autowired
    HotelService hotelService;
    @Autowired
    FlightService flightService;
    @GetMapping("/hotels")
    public String  hotels(Model model, HttpSession httpSession){
        Airport city=flightService.city((String) httpSession.getAttribute("arrival"));
        List<Hotel> hotelList=hotelService.findbycity(city.getCity());

        System.out.println("from hotel  "+hotelList.size());
        model.addAttribute("hotelsbycity", hotelList);
        return "hotelbycity";
    }

    @GetMapping("/room")
    public String  flight(){
        return "test";
    }
}

