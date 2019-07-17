package com.project.tripadvisor.hotelres.repository;

import com.project.tripadvisor.hotelres.domain.Hotel;
import com.project.tripadvisor.hotelres.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HotelRepo extends JpaRepository<Hotel,Long> {

    List<Hotel> findAllByCity(String city);
}
