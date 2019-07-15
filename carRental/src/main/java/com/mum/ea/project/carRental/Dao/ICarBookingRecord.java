package com.mum.ea.project.carRental.Dao;

import com.mum.ea.project.carRental.Model.CarBookingRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarBookingRecord extends JpaRepository<CarBookingRecord,Long> {
public CarBookingRecord findByEmail(String email);
}
