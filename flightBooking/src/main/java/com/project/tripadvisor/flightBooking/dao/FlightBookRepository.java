package com.project.tripadvisor.flightBooking.dao;

import com.project.tripadvisor.flightBooking.model.Flight;
import com.project.tripadvisor.flightBooking.model.FlightBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightBookRepository extends JpaRepository<FlightBook,Long> {
    public List<FlightBook> findAllByFlight(Flight flight);
}
