package com.project.tripadvisor.flightBooking.service.serviceImpl;

import com.project.tripadvisor.flightBooking.dao.AirlinesRepository;
import com.project.tripadvisor.flightBooking.dao.AirportRepository;
import com.project.tripadvisor.flightBooking.model.Airport;
import com.project.tripadvisor.flightBooking.service.AirlinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AirlinesServiceImpl implements AirlinesService {
    @Autowired
    private AirportRepository airlinesRepository;
    @Override
    public Airport add(Airport airlines)
    {
        return airlinesRepository.save(airlines);
    }

    @Override
    public List<Airport> getAirlines() {
        return airlinesRepository.findAll();
    }
    @Override
    public void delete(Long id) {
        airlinesRepository.deleteById(id);
    }
}
