package com.tripadvisor.integration.model;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Data
public class Hotel implements Serializable {
    private Long id;
    private String name;
    private String description;
    private String image;
    private String city;
    private List<Room> roooms = new ArrayList<>();
    public Hotel(String name, String description, String image, String city) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.city = city;
    }

    public boolean addRoom(Room room){
        if(roooms.add(room)){
            room.setHotel(this);
            return true;
        }
        return false;
    }
}
