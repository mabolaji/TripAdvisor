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

import javax.lang.model.element.VariableElement;
import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private IBookingService bookingService;
    @GetMapping
    public String index(@ModelAttribute("booking")  Booking booking, Model model) {

        model.addAttribute("origins",  bookingService.getOrigins());
        model.addAttribute("destinations",  bookingService.getDestinations(booking.getOriginId()));


        if (!model.containsAttribute("booking")) {
            model.addAttribute("booking", booking);

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

    @PostMapping("/search")
    public String search( @Valid Booking booking, BindingResult result,RedirectAttributes flash) {

        List<String> errors = new ArrayList<>();

        if(result.hasErrors()){
           System.out.println("result.getErrorCount()");
           for( ObjectError dd: result.getAllErrors()){
              System.out.println( dd.getDefaultMessage());
           }
        }
        if(booking.getOriginId()==null || booking.getOriginId()==0){
            errors.add("Kindly select origin");
        }
        if(booking.getDestinationId()==null || booking.getDestinationId()==0){
            errors.add("Kindly select destination");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        if(booking.getFrom()==null){
            errors.add("Kindly select origin");
        }
        else {
            try {
               // LocalDate arrivalDate1 = LocalDate.parse(booking.getFrom(), formatter);
            }
            catch (Exception ex){

            }
        }
        flash.addFlashAttribute("booking", booking);
        System.out.println(booking);
        System.out.println(flash.getFlashAttributes().keySet());



        return "redirect:/home?search="+result.getErrorCount();
    }

    @GetMapping("/temp")
    public String testpage(){
        return "test";
    }

}
