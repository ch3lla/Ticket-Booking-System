package com.emmanuella.TicketBookingSystem.repository;

import com.emmanuella.TicketBookingSystem.models.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketBookingRepository extends CrudRepository<Ticket, Integer> {
    Ticket findByEmail(String email);
}
