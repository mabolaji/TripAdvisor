package com.project.tripadvisor.hotelres.service.Impl;

import com.project.tripadvisor.hotelres.domain.Reservation;
import com.project.tripadvisor.hotelres.repository.ReservationRepo;
import com.project.tripadvisor.hotelres.service.ReservationService;
import com.project.tripadvisor.hotelres.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    ReservationRepo reservationRepo;
    @Autowired
    RoomService roomService;

    @Override
    public void reserve(Reservation reservation) {
        roomService.changeRoomStatus(reservation.getRoom());
        reservationRepo.save(reservation);
    }
}
