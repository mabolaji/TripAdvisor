package com.project.tripadvisor.hotelres.service;

import com.project.tripadvisor.hotelres.domain.Room;
import com.project.tripadvisor.hotelres.repository.RoomRepo;

import java.util.List;

public interface RoomService {
    List<Room> findAll();
    List<Room> findHotelRooms(String hotelId);
    void changeRoomStatus(Room room);
    Room findRoom(Long roomId);
    Long addRoom(Room room);
    void clear(Long roomId);
}
