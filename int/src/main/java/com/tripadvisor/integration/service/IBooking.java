package com.tripadvisor.integration.service;

import com.tripadvisor.integration.model.Airport;

import java.util.List;

public interface IBooking {
    List<Airport> getOrigings();
}
