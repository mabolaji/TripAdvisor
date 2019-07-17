package com.project.tripadvisor.flightBooking.service.serviceImpl;

import com.project.tripadvisor.flightBooking.dao.AirplaneRepository;
import com.project.tripadvisor.flightBooking.dao.AirportRepository;
import com.project.tripadvisor.flightBooking.model.Airport;
import com.project.tripadvisor.flightBooking.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportServiceImpl implements AirportService {
    @Autowired
    private AirportRepository airportRepository;

    @Override
    public List<Airport> getOrigin() {
        return airportRepository.findAll();
    }


}
