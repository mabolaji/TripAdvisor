package com.project.tripadvisor.flightBooking.dao;

import com.project.tripadvisor.flightBooking.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {
    @Query( value ="SELECT * FROM flightbook.flight where departure=?1 and arrival=?2 and departure_date like ?3% and arrival_date like ?4%",nativeQuery = true)
    public List<Flight> findAllByDepartureAndArrivalAndDepartureDateAndArrivalDate(String departure, String arrival, LocalDate departureDate, LocalDate arrivalDate);
    public List<Flight> findByArrivalAndDeparture(String arrival, String departure);


}
