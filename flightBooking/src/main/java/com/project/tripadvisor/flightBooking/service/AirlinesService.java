package com.project.tripadvisor.flightBooking.service;

import com.project.tripadvisor.flightBooking.model.Airlines;

import java.util.List;

public interface AirlinesService {
    public Airlines add(Airlines airlines);
    public List<Airlines> getAirlines();

    public void delete(Long id);
}
