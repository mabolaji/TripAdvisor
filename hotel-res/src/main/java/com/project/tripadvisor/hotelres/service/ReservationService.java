package com.project.tripadvisor.hotelres.service;

import com.project.tripadvisor.hotelres.domain.Reservation;
import com.project.tripadvisor.hotelres.repository.ReservationRepo;

public interface ReservationService  {
    void reserve(Reservation reservation);
}
