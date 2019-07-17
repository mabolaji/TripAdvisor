package com.tripadvisor.integration.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

//import javax.persistence.*;
import java.util.List;

@Data
public class Airlines {

    private  Long id;

    private String name;


    private List<Flight> flightList;

    private List<Airplanes> airplanes;


}
