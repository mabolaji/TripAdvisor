package com.project.tripadvisor.hotelres.service.Impl;

import com.project.tripadvisor.hotelres.domain.Hotel;
import com.project.tripadvisor.hotelres.repository.HotelRepo;
import com.project.tripadvisor.hotelres.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    HotelRepo hotelRepo;

    @Override
    public List<Hotel> findAllByCity(String city) {
        return hotelRepo.findAllByCity(city);
    }

    @Override
    public List<Hotel> findAll() {
        return hotelRepo.findAll();
    }


}
