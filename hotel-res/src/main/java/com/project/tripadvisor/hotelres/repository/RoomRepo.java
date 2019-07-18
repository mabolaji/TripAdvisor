package com.project.tripadvisor.hotelres.repository;

import com.project.tripadvisor.hotelres.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepo extends JpaRepository<Room,Long> {
    @Query("select r from Room r where r.hotel.name=?1 and r.status=1")
    public List<Room> findHotelRooms(String hotelId);


}
