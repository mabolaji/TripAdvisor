package com.mum.ea.project.carRental.Controller;

import com.mum.ea.project.carRental.Dao.ICarDao;
import com.mum.ea.project.carRental.Model.Car;
import com.mum.ea.project.carRental.Model.CarDTO;
import com.mum.ea.project.carRental.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/carRental")
public class CarController {
    @Autowired
    private CarService carService;
    @Autowired
    private ICarDao iCarDao;


//    @GetMapping("/cars")
//    public List<Car> getAll() {
//
//        List<Car> carList=carService.getallCars();
//        List<Car> carL=new ArrayList<>();
//        for(Car c:carList){
//            if(!(c.getCarbookinglist().stream().filter(f->f.getDropDate().after(new Date())).collect(Collectors.toList()).size()>0)){
//                c.setStatus(true);
//                carService.update(c);
//            }
//        }
//
//
//
//        List<CarDTO> list =  new ArrayList<>();
//        flights
//                .stream()
//                .forEach(f -> {
//                    FlightDto data =  new FlightDto();
//                    data.setFlightNumber(f.getFlightNumber());
//                    data.setAirLine(f.getAirplane().getAirline().getName());
//                    data.setArrival_city(f.getArrival().getCity());
//                    data.setId(f.getId());
//                    data.setArrival_city(f.getArrival().getCity());
//                    data.setArrival_date(f.getArrivalDate());
//                    data.setDeparture_date(f.getDepartureDate());
//                    data.setReg_num(f.getAirplane().getRegestrationNo());
//                    data.setDeparture_city(f.getDeparture().getCity());
//                    list.add(data);
//                });
//
//
//
//
//        return carService.getallCars().stream().filter(f->f.isStatus()).collect(Collectors.toList());
//    }



    @GetMapping("/cars")
    public List<CarDTO> getAll() {

        List<Car> carList=carService.getallCars();
        List<Car> carL=new ArrayList<>();
        for(Car c:carList){
            if(!(c.getCarbookinglist().stream().filter(f->f.getDropDate().after(new Date())).collect(Collectors.toList()).size()>0)){
                c.setStatus(true);
                carService.update(c);
            }
        }
        carL=carService.getallCars().stream().filter(f->f.isStatus()).collect(Collectors.toList());


                List<CarDTO> list =  new ArrayList<>();
        carL
                .stream()
                .forEach(f -> {
                    CarDTO data =  new CarDTO();
                    data.setCarName(f.getCarName());
                    data.setCarBrand(f.getBrand());
                    data.setCarTransmissiontype(f.getCarTransmissiontype());
                    data.setImageurl(f.getImageurl());
                    data.setCompLocation(f.getRentalComp().getLocation());
                    data.setSeatingCapacity(f.getSeatingCapacity());
                    data.setPrice(f.getPrice());
                    list.add(data);
                });




        return list;
    }




    @GetMapping("/carsearchByBrand")
    public List<Car> getCarByBrand(@RequestParam String brand) {
        return carService.getCarByBrand(brand);
    }

    @GetMapping("/carsearchByComp")
    public List<Car> getCarByComp(@RequestParam String company) {
        return carService.findAllByRentalComp(Long.parseLong(company));
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
