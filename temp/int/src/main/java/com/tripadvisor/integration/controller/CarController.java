package com.tripadvisor.integration.controller;

import com.tripadvisor.integration.model.CarBookingRecord;
import com.tripadvisor.integration.service.CarProxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class CarController {
    @Autowired
    public CarProxyService carProxyService;

    @GetMapping(value = "cars")
    public String getcar(Model model, HttpSession httpSession) {
        String id = (String) httpSession.getAttribute("arrival");
        System.out.println("testttttttttt arrival id" + id);
        model.addAttribute("cars", carProxyService.findCars(id));
        return "cars";

    }

    @PostMapping(value = "/cars")
    public String book(@Valid CarBookingRecord carBookingRecord, BindingResult bindingResult) {
        //CarBookingRecord msg =  new CarBookingRecord();
        System.out.println(carBookingRecord.toString());
        //rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, msg);
        return "redirect:/cars?sss=" + carBookingRecord.toString();
    }
}
