package com.tripadvisor.integration.service;

import com.tripadvisor.integration.model.Hotel;
import com.tripadvisor.integration.model.Room;

import java.util.List;

public interface HotelService {

    List<Hotel> findAllHotels();

    List<Hotel> findbycity(String city);
    public List<Room> rooms(String hotel);
}
