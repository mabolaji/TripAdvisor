package com.cs544.user.user.domain;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@ToString
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(nullable = false)
    @Email
    private String cust_email;
    @ManyToOne
    private Restaurant restaurant;
    @NotNull
    @Column(nullable = false)
    private Date startDate;
    @NotNull
    @Column(nullable = false)
    private Date endDate;
}
