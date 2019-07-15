package com.mum.ea.project.carRental.Controller;

import com.mum.ea.project.carRental.Model.Car;
import com.mum.ea.project.carRental.Model.CarBookingRecord;
import com.mum.ea.project.carRental.Service.CarBookingService;
import com.mum.ea.project.carRental.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/carRental")
public class CarBookingController {

    @Autowired
    private CarBookingService carBookingService;
    @Autowired
    private CarService carService;
    @GetMapping("/carsRecord")
    public List<CarBookingRecord> getAll() {
        return carBookingService.getallRecords();
    }

    @GetMapping("/carsRecord/search")
    public CarBookingRecord get(@RequestParam String email) {
        return carBookingService.getRecordByEmail(email);
    }

    @PostMapping("/carsRecord")
    public void add(@RequestBody CarBookingRecord carBookingRecord) {

        CarBookingRecord carbook=carBookingRecord;
        Car car=carbook.getCar();
        if(car.isStatus()) {
            carBookingRecord.getCar().setStatus(false);
            carService.update(carBookingRecord.getCar());
            carBookingService.add(carBookingRecord);
        }else{
            System.out.println("Sorryyyyyyy");
        }
    }

    @PutMapping("/carsRecord/{id}")
    public void update(@RequestBody CarBookingRecord carBookingRecord) {
        carBookingService.update(carBookingRecord);
    }

    @DeleteMapping("/carsRecord/{id}")
    public void delete(@PathVariable int id) {
        carBookingService.delete(id);
    }
}
