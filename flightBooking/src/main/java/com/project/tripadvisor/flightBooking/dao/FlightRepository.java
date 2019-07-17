package com.project.tripadvisor.flightBooking.dao;

import com.project.tripadvisor.flightBooking.model.Airport;
import com.project.tripadvisor.flightBooking.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {
//    @Query("SELECT distinct f FROM Flight f where f.departure.city=?1 and f.arrival.city=?2 and f.departureDate like %?3%")
//@Query("Select Distinct f from Flight f where f.departure.city=?1")

    @Query( value ="SELECT * FROM flightbook.flight \n" +

            "where departure_id=?1 and arrival_id=?2 and departure_date like ?3% and arrival_date like ?4%",nativeQuery = true)

    public List<Flight> findAllByDepartureAndArrivalAndDepartureDateAndArrivalDate(long departureId, long
            arrivalId, LocalDate departureDate, LocalDate arrivalDate);

    @Query( value ="SELECT * FROM flightbook.flight f\n" +
            "where departure_id=?1 and arrival_id=?2 and departure_date like ?3%",nativeQuery = true)
    public List<Flight> findAllByDepartureAndArrivalAndDepartureDate(long departureId, long
            arrivalId, LocalDate departureDate);


    public List<Flight> findByArrivalAndDeparture(String arrival, String departure);


    @Query("Select Distinct f from Flight f where f.departure.id=?1")
    public List<Flight> findAllByDeparture(Long departure);


}
