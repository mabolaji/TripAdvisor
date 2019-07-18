package com.mum.ea.project.carRental.Dao;

import com.mum.ea.project.carRental.Model.Rentalcompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IRentalCompany extends JpaRepository<Rentalcompany,Long> {
    public List<Rentalcompany> findAllByLocation(String location);
}
