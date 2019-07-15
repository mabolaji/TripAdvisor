package com.mum.ea.project.carRental.Dao;

import com.mum.ea.project.carRental.Model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICarDao extends JpaRepository<Car, Long> {
    public List<Car> findAllByBrand(String brand);
    public List<Car> findAllByBrandAndAndRentalComp(String brand,long id);



}