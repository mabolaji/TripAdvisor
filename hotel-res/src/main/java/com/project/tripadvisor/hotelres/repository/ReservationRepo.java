package com.project.tripadvisor.hotelres.repository;

import com.project.tripadvisor.hotelres.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepo extends JpaRepository<Reservation,Long> {
}
