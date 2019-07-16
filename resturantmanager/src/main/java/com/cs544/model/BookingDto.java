package com.cs544.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BookingDto implements Serializable {
    private Integer rest_id;
    private String cust_email;
    private Date startDate;
    private Date endDate;
}
