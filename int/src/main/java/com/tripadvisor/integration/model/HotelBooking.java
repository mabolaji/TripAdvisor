package com.tripadvisor.integration.model;

import lombok.Data;
import org.aspectj.bridge.Message;

import javax.validation.constraints.Email;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data

public class HotelBooking  implements Serializable {

   @NotNull(message = "Email is required")
   @Email(message = "In valid email")
   private String email;
   @NotNull
   private Long hotelId;
   @NotNull(message = "In valid check in date")
   @FutureOrPresent
   private LocalDate inDate;
   @NotNull(message = "In valid check out date")
   @FutureOrPresent
   private  LocalDate outDate;
   @NotNull(message = "Kindly select a room")
   private Long roomId ;

}
