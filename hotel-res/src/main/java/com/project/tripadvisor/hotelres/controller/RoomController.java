//package com.project.tripadvisor.hotelres.controller;
//
//import com.project.tripadvisor.hotelres.domain.Room;
//import com.project.tripadvisor.hotelres.service.RoomService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
////@RequestMapping("/api")
//public class RoomController {
//    @Autowired
//    RoomService roomService;
//
//    @GetMapping("/rooms/")
//    public List<Room> getRooms(@RequestParam("hotel") String hotel){
//        return roomService.findHotelRooms(hotel);
//    }
//
//    @GetMapping("/allrooms")
//    public List<Room> allRooms(){
//        return roomService.findAll();
//    }
//}
