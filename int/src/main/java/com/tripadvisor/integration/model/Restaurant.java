package com.tripadvisor.integration.model;

import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class Restaurant {
    private Integer id;
    private String name;
    private String description;
    private String img_url;
    private String url;
    private String manager_email;

}
