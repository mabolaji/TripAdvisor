package com.project.tripadvisor.hotelres.service;

import com.project.tripadvisor.hotelres.domain.Hotel;
import com.project.tripadvisor.hotelres.domain.Room;
import com.project.tripadvisor.hotelres.repository.HotelRepo;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HotelService  {

    List<Hotel> findAllByCity(String city);
    List<Hotel> findAll();

}
