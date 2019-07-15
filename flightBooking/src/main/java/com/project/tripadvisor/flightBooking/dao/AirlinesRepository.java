package com.project.tripadvisor.flightBooking.dao;

import com.project.tripadvisor.flightBooking.model.Airlines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlinesRepository extends JpaRepository<Airlines,Long> {
}
