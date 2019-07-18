package com.project.tripadvisor.hotelres.service;

import com.project.tripadvisor.hotelres.domain.Hotel;
import com.project.tripadvisor.hotelres.domain.Room;
import com.project.tripadvisor.hotelres.repository.HotelRepo;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HotelService  {

    Long addHotel(Hotel hotel);
    Hotel findHotel(Long id);
    Long updateHotel(Hotel hotel);
    void deleteHotel(Hotel hotel);
    List<Hotel> findAllHotels();
    List<Hotel> findAllByCity(String city);
    List<Hotel> findAllByCityAndStar(String city, int Star);

//    Long addHotel(Hotel hotel);
//    List<Hotel> findHotelByCityAndStar(String city, int star);

}
