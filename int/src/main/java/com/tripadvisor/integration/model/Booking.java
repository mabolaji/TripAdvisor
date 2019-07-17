package com.tripadvisor.integration.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class Booking {
    private Long originId;
    private Long destinationId;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date from;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date to;
}

