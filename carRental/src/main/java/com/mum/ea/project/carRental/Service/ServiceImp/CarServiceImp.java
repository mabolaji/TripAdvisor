package com.mum.ea.project.carRental.Service.ServiceImp;

import com.mum.ea.project.carRental.Dao.ICarDao;
import com.mum.ea.project.carRental.Model.Car;
import com.mum.ea.project.carRental.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Service
public class CarServiceImp implements CarService {
    @Autowired
    private ICarDao carDao;
    @Override
    public void add(Car car) {
        carDao.save(car);
    }

    @Override
    public Car getCar(long carId) {
        return carDao.findById(carId).get();
    }

    @Override
    public List<Car> getCarByBrand(String brand) {
        return carDao.findAllByBrand(brand);
    }

    @Override
    public List<Car> getallCars() {
        return carDao.findAll();
    }

    @Override
    public void update(Car car) {
        carDao.save(car);
    }

    @Override
    public void delete(long id) {
        carDao.deleteById(id);
    }

    @Override
    public List<Car> findAllByBrandAndAndRentalComp(String brand, long id) {
        return carDao.findAllByBrandAndAndRentalComp(brand,id);
    }
}
