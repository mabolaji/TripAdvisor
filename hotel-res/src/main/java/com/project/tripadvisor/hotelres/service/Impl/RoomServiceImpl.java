package com.project.tripadvisor.hotelres.service.Impl;

import com.project.tripadvisor.hotelres.domain.Room;
import com.project.tripadvisor.hotelres.repository.RoomRepo;
import com.project.tripadvisor.hotelres.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    RoomRepo roomRepo;

    @Override
    public List<Room> findHotelRooms(String hotelId) {
        return roomRepo.findHotelRooms(hotelId);
    }

    @Override
    public void changeRoomStatus(Room room) {
        room.setStatus(0);
        roomRepo.save(room);
    }

    @Override
    public Room findRoom(Long roomId) {
        return roomRepo.getOne(roomId);
    }
}
