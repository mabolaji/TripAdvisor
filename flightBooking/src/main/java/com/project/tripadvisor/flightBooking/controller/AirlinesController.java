package com.project.tripadvisor.flightBooking.controller;

import com.project.tripadvisor.flightBooking.model.Airlines;
import com.project.tripadvisor.flightBooking.service.AirlinesService;
import com.project.tripadvisor.flightBooking.service.serviceImpl.AirlinesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airlines")
public class AirlinesController {
    @Autowired
    private AirlinesService airlinesService;

    @PostMapping(value = "/add")
    public Airlines add(@RequestBody Airlines airlines) {
        return airlinesService.add(airlines);
    }

    @GetMapping(value = "/getflight")
    public List<Airlines> getAirlines() {
        return airlinesService.getAirlines();
    }

    @GetMapping(value = "/delete")
    public void delete(@RequestParam Long id) {
        airlinesService.delete(id);
    }

}
