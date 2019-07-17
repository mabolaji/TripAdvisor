package com.project.tripadvisor.flightBooking.controller;

import com.project.tripadvisor.flightBooking.model.Airport;
import com.project.tripadvisor.flightBooking.service.serviceImpl.AirlinesServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airlines")
public class AirlinesController {
    @Autowired
    private AirlinesServiceImpl airlinesService;

    @PostMapping(value="/add")
    public Airport add(@RequestBody Airport airlines)
    {
        return  airlinesService.add(airlines);
    }

    @GetMapping(value ="/getairline")
    public List<Airport> getAirlines()
    {
        return  airlinesService.getAirlines();
    }

    @GetMapping(value = "/delete")
    public void delete(@RequestParam Long id)
    {
        airlinesService.delete(id);
    }



}
