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
    public Long addHotel(Hotel hotel) {
        return hotelRepo.save(hotel).getId();
    }

    @Override
    public Hotel findHotel(Long id) {
        return hotelRepo.findById(id).get();
    }

    @Override
    public Long updateHotel(Hotel hotel) {
        return hotelRepo.save(hotel).getId();
    }

    @Override
    public void deleteHotel(Hotel hotel) {
        hotelRepo.delete(hotel);
    }

    @Override
    public List<Hotel> findAllHotels() {
        return hotelRepo.findAll();
    }

    @Override
    public List<Hotel> findAllByCity(String city) {
        return hotelRepo.findAllByCity(city);
    }

    @Override
    public List<Hotel> findAllByCityAndStar(String city, int star) {
        return hotelRepo.findHotelByCityaAndAndStar(city,star);
    }

}
