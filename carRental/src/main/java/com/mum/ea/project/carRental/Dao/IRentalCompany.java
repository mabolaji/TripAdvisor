package com.mum.ea.project.carRental.Dao;

import com.mum.ea.project.carRental.Model.RentalCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IRentalCompany extends JpaRepository<RentalCompany,Long> {
    public List<RentalCompany> findAllByLocation(String location);
}
