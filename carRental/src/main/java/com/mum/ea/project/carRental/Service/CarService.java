package com.mum.ea.project.carRental.Service;

import com.mum.ea.project.carRental.Model.Car;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CarService {
    public void add(Car car);
    public Car getCar(long carId);
    public List<Car> getCarByBrand(String brand);
    public List<Car> getallCars();
    public void update(Car car);
    public void delete(long id);
    public List<Car> findAllByBrandAndAndRentalComp(String brand,long id);

    public List<Car> findAllByRentalComp(long id);
    public List<Car> findAllByStatusTrue();

}
