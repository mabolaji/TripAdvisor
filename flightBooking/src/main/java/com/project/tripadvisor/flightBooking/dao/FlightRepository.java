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

    @Query( value ="SELECT * FROM flightbook.flight f\n" +
            "join flightbook.airport d on f.departure_id=d.id\n" +
            "join flightbook.airport a on f.arrival_id=a.id\n" +
            "where d.city=?1 and a.city=?2 and departure_date like ?3% and arrival_date like ?4%",nativeQuery = true)

    public List<Flight> findAllByDepartureAndArrivalAndDepartureDateAndArrivalDate(String departure, String
            arrival, LocalDate departureDate, LocalDate arrivalDate);

//    @Query( value ="SELECT distinct f FROM flightbook.flight f where f.departure.city=?1 and f.arrival.city=?2 and f.departureDate like ?3%")
    public List<Flight> findAllByDepartureAndArrivalAndDepartureDate(String departure, String arrival, LocalDate departureDate);




    public List<Flight> findByArrivalAndDeparture(String arrival, String departure);

    //@Query(value="SELECT * FROM flightbook.flight f where f.departure.city=?1 ",nativeQuery = true)
    @Query("Select Distinct f from Flight f where f.departure.city=?1")
    public List<Flight> findAllByDeparture(String departure);


}
