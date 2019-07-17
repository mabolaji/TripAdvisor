package com.tripadvisor.integration.model;

import lombok.Data;

import java.util.Date;

@Data

public class CarBookingRecord {

   private Long id;
   private String email;
   private Car car;
   private Date pickdate;
   private  Date dropDate;

    public CarBookingRecord(String email, Car car, Date pickdate, Date dropDate) {
        this.email = email;
        this.car = car;
        this.pickdate = pickdate;
        this.dropDate = dropDate;
    }
}
