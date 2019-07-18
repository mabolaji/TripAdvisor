package com.project.tripadvisor.hotelres.repository;

import com.project.tripadvisor.hotelres.domain.Hotel;
import com.project.tripadvisor.hotelres.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepo extends JpaRepository<Hotel,Long> {

    List<Hotel> findAllByCity(String city);
    @Query("select h from Hotel h where h.city=?1 and h.star=?2")
    List<Hotel> findHotelByCityaAndAndStar(String city, int star);
}
