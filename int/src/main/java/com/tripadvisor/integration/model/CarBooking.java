package com.tripadvisor.integration.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data

public class CarBooking {

   @NotNull
   @Email
   private String email;
   @NotNull
   private Long carId;
   @NotNull
   @FutureOrPresent
   private Date pickDate;
   @NotNull
   @FutureOrPresent
   private  Date dropDate;

}
