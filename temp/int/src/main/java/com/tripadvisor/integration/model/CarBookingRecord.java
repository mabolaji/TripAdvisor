package com.tripadvisor.integration.model;

import lombok.Data;

import java.util.Date;

@Data

public class CarBookingRecord {

   private Long id;
   private String email;
   private Long carId;
   private Date pickdate;
   private  Date dropDate;

}
