package com.project.tripadvisor.hotelres.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int roomNo;
    private int beds;
    private double price;
    private int status;
    private String image;
    private String type;
    @ManyToOne
    @JsonBackReference
    private Hotel hotel;

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomNo=" + roomNo +
                ", beds=" + beds +
                ", price=" + price +
                ", status=" + status +
                ", image='" + image + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
