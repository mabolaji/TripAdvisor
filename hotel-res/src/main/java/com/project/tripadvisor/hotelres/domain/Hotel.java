package com.project.tripadvisor.hotelres.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String image;
    private String city;
    @OneToMany(mappedBy = "hotel",fetch = FetchType.EAGER)
    @JsonManagedReference
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
