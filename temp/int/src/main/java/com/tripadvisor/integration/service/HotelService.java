package com.tripadvisor.integration.service;

import com.tripadvisor.integration.model.Hotel;

import java.util.List;

public interface HotelService {

    List<Hotel> findAllHotels();
}
