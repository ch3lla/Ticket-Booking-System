package com.emmanuella.TicketBookingSystem.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ticket {
    @Id
    @GeneratedValue(generator = "custom-ticket-id")
    @GenericGenerator(name = "custom-ticket-id", strategy = "com.emmanuella.TicketBookingSystem.security.CustomTicketIdGenerator")
    private String ticketId;

    private String passengerName;
    private Date bookingDate;
    private String sourceStation;
    private String destStation;
    private String email;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "bus_ticket", joinColumns = @JoinColumn(name = "ticket_id", referencedColumnName = "ticketId"),
            inverseJoinColumns = @JoinColumn(name = "bus_id", referencedColumnName = "id"))
    private List<Bus> bus = new ArrayList<>();

}
