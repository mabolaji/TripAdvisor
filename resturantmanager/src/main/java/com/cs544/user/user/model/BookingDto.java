package com.cs544.user.user.model;

import java.io.Serializable;
import java.util.Date;

public class BookingDto implements Serializable {
    private Integer rest_id;
    private String cust_email;
    private Date startDate;
    private Date endDate;
}
