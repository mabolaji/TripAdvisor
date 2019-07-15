package com.mum.ea.project.carRental.Controller;

import com.mum.ea.project.carRental.Model.Car;
import com.mum.ea.project.carRental.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/carRental")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public List<Car> getAll() {

        List<Car> carList=carService.getallCars();
        List<Car> carL=new ArrayList<>();
        for(Car c:carList){
            if(!(c.getCarbookinglist().stream().filter(f->f.getDropDate().after(new Date())).collect(Collectors.toList()).size()>0)){
                c.setStatus(true);
                carService.update(c);
            }
        }
        return carService.getallCars().stream().filter(f->f.isStatus()).collect(Collectors.toList());
    }

    @GetMapping("/cars/search")
    public List<Car> getCarByBrand(@RequestParam String brand) {
        return carService.getCarByBrand(brand);
    }
    @GetMapping("/cars/{id}")
    public Car getcarId(@PathVariable long id) {
        return carService.getCar(id);
    }
    @PostMapping("/cars")
    public void add(@RequestBody Car car) {
        carService.add(car);
    }

    @PutMapping("/cars/{id}")
    public void update(@RequestBody Car car) {
        carService.update(car);
    }

    @DeleteMapping("/cars/{id}")
    public void delete(@PathVariable int id) {
        carService.delete(id);
    }
}
