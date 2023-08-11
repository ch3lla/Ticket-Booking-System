package com.emmanuella.TicketBookingSystem.service;


import com.emmanuella.TicketBookingSystem.models.Ticket;
import com.emmanuella.TicketBookingSystem.repository.TicketBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketBookingService {

    @Autowired
    private TicketBookingRepository ticketBookingRepository;

    public Ticket createTicket(Ticket ticket){
        return ticketBookingRepository.save(ticket);
    }

    public Optional<Ticket> getTicketById(Integer ticketId){
        return ticketBookingRepository.findById(ticketId);
    }

    public Iterable<Ticket> getAllBookedTickets(){
        return ticketBookingRepository.findAll();
    }

    public void deleteTicket(Integer ticketId){
        ticketBookingRepository.deleteById(ticketId);
    }

    public Ticket updateTicket(String email, String newEmail){
        Ticket ticketFromDb = ticketBookingRepository.findByEmail(email);
        ticketFromDb.setEmail(newEmail);
        return ticketBookingRepository.save(ticketFromDb);
    }

    public Ticket getTicketByEmail(String email){
        return ticketBookingRepository.findByEmail(email);
    }

}
