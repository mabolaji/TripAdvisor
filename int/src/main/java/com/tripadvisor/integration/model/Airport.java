package com.tripadvisor.integration.model;

import lombok.Data;

<<<<<<< HEAD


@Data
=======
>>>>>>> master
public class Airport {

    private  Long id;
<<<<<<< HEAD

    private String name;

    private String country;

    private String city;

    private String airportCode;

//    @OneToMany(mappedBy = "departure")
//    @JsonManagedReference
//    private List<Flight> origin=new ArrayList();
//
//    @OneToMany(mappedBy = "arrival",fetch = FetchType.EAGER)
//    @JsonManagedReference
//    private List<Flight> destinition=new ArrayList();





=======
    private  String name;

    @Override
    public String toString() {
        return  name ;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
>>>>>>> master
}
