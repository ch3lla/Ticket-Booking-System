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

    @Temporal(TemporalType.DATE)
    private Date dateOfDeparture;
    private String sourceStation;
    private String destStation;
    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
        updatedAt = createdAt; // Initialize updatedAt with createdAt on creation
    }
    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();
    }


/*    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "bus_ticket", joinColumns = @JoinColumn(name = "ticket_id", referencedColumnName = "ticketId"),
            inverseJoinColumns = @JoinColumn(name = "bus_id", referencedColumnName = "id"))
    private List<Bus> bus = new ArrayList<>();*/

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "bus_id", referencedColumnName = "id")
    private Bus bus;

}
