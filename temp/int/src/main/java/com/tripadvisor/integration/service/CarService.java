package com.tripadvisor.integration.service;

import com.tripadvisor.integration.model.CarBookingRecord;
import com.tripadvisor.integration.model.CarDTO;

import java.util.List;

public interface CarService {
    public  List<CarDTO> findCars(String id);

}
