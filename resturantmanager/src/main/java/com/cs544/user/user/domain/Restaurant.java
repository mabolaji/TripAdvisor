package com.cs544.user.user.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@ToString
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(nullable = false)
    private String name;
    @NotNull
    @Column(nullable = false)
    private String description;
    @NotNull
    @Column(nullable = false)
    private String img_url;
    @URL
    @NotNull
    @Column(nullable = false)
    private String url;
    @NotNull
    @Column(nullable = false)
    @Email
    private String manager_email;

}
