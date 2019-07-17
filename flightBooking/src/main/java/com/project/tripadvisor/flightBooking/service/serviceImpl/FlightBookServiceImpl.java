package com.project.tripadvisor.flightBooking.service.serviceImpl;

import com.project.tripadvisor.flightBooking.dao.AirplaneRepository;
import com.project.tripadvisor.flightBooking.dao.FlightBookRepository;
import com.project.tripadvisor.flightBooking.dao.FlightRepository;
import com.project.tripadvisor.flightBooking.model.Airport;
import com.project.tripadvisor.flightBooking.model.Flight;
import com.project.tripadvisor.flightBooking.model.FlightBook;
import com.project.tripadvisor.flightBooking.service.FlightBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Service
@Transactional
public class FlightBookServiceImpl implements FlightBookService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private FlightBookRepository flightBookRepository;
    @Autowired
    private AirplaneRepository airplaneRepository;
    @Override
    public List<Flight> flightes(Long departure, Long arrival, LocalDate departureDate, LocalDate arrivalDate) {
        return flightRepository.findAllByDepartureAndArrivalAndDepartureDateAndArrivalDate(departure,arrival,departureDate,arrivalDate);
    }

    @Override
    public FlightBook bookFlight(String email, Flight flight)
    {
        FlightBook flightBook=new FlightBook();
        flightBook.setEmail(email);
        flightBook.setFlight(flight);
        List<FlightBook> flightBooks=flightBookRepository.findAllByFlight(flight);
        System.out.println("testt "+ flightBooks.size()+ "  "+flightRepository.findById(flight.getId()).get().getAirplane().getSeat());
        if(flightBooks.size()<flightRepository.findById(flight.getId()).get().getAirplane().getSeat()) {
            return flightBookRepository.save(flightBook);
        }
        return  null;
    }

    @Override
    public List<Flight> flightesFilter(Long departure, Long arrival, LocalDate departureDate) {
        return flightRepository.findAllByDepartureAndArrivalAndDepartureDate(departure,arrival,departureDate);
    }

    @Override
    public List<Airport> departureFlight(Long departure) {
        return flightRepository.findAllByDeparture(departure);
    }

    public  List<Flight> test(String arrival,String departure)
    {
        return flightRepository.findByArrivalAndDeparture(arrival,departure);
    }
    public List<Flight> ActualFight(){
        return  flightRepository.listActualFight();
    }


}
