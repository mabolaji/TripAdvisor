//package com.project.tripadvisor.hotelres.controller;
//
//import com.project.tripadvisor.hotelres.domain.Reservation;
//import com.project.tripadvisor.hotelres.domain.Room;
//import com.project.tripadvisor.hotelres.service.ReservationService;
//import com.project.tripadvisor.hotelres.service.RoomService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//
//@RestController
////@RequestMapping("/api/hotel")
//public class ReservationController {
//    @Autowired
//    ReservationService reservationService;
//
//    @Autowired
//    RoomService roomService;
//
//    @PostMapping("/reserve/")
//    public void reserve(@RequestParam("email") String email,
//                        @RequestParam("checkIn")String checkIn,
//                        @RequestParam("checkOut") String checkOut,
//                        @RequestParam("roomId") Long roomId){
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate cIn = LocalDate.parse(checkIn, formatter);
//        LocalDate cOut = LocalDate.parse(checkOut, formatter);
//        Room room = roomService.findRoom(roomId);
//        reservationService.reserve(new Reservation(email,cIn,cOut,room));
//    }
//
//    @PutMapping("/clear/")
//    public void clear(Long roomId){
//        roomService.clear(roomId);
//    }
//}
