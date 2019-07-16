package com.project.tripadvisor.flightBooking.service;

import com.project.tripadvisor.flightBooking.model.Airlines;

import java.util.List;

public interface AirlinesService {
     Airlines add(Airlines airlines);
     List<Airlines> getAirlines();

     void delete(Long id);
}
