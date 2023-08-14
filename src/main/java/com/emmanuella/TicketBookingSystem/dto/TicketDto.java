package com.emmanuella.TicketBookingSystem.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TicketDto {
    private String passengerName;
    private Date bookingDate;
    private String sourceStation;
    private String destStation;
    private String email;
}
