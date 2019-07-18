package com.tripadvisor.integration.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

//import javax.persistence.*;
import javax.persistence.OneToMany;
import java.util.List;

@Data
public class Airlines {

    private  Long id;

    private String name;

    @OneToMany(mappedBy = "airlines")
    private List<Flight> flightList;

    @OneToMany(mappedBy = "airline")
    private List<Airplanes> airplanes;


}
