package com.tripadvisor.integration.controller;

import com.tripadvisor.integration.model.CarBooking;
import com.tripadvisor.integration.service.CarProxyService;
import com.tripadvisor.integration.util.Common;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {


    private static final String ROUTING_KEY = "car_booking_queue";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public CarProxyService carProxyService;

    @GetMapping(value = "cars")
    public String cars(Model model, HttpSession httpSession) {

        try {
            System.out.println("httpSession.getAttribute(\"arrival\") : " +httpSession.getAttribute("arrival"));
            String id =  httpSession.getAttribute("arrival").toString();
            model.addAttribute("cars", carProxyService.findCars(id));
            return "cars";
        }
        catch (Exception ex){
            System.out.println(ex.toString());
            return  "redirect:/home";
        }
    }

    @PostMapping(value = "/cars")
    public String cars(@Valid CarBooking booking, BindingResult bindingResult, RedirectAttributes flash) {

        if(bindingResult.hasErrors()){
            List<String> errors =  new ArrayList<>();
            for (ObjectError error : bindingResult.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
                errors.add(error.getDefaultMessage());

                flash.addFlashAttribute("errors", errors);
            }
            return "/cars";
        }
        else{
            rabbitTemplate.convertAndSend(Common.EXCHANGE, ROUTING_KEY, booking);
            return "redirect:/hotels" ;
        }

    }
}
