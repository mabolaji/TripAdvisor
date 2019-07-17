package com.project.tripadvisor.flightBooking.dao;

import com.project.tripadvisor.flightBooking.model.Airplanes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplanes,Long> {
}
