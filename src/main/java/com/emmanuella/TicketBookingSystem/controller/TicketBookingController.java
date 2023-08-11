package com.emmanuella.TicketBookingSystem.controller;

import com.emmanuella.TicketBookingSystem.models.Ticket;
import com.emmanuella.TicketBookingSystem.service.TicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TicketBookingController {

    @Autowired
    private TicketBookingService ticketBookingService;

    @PostMapping(value = "/ticket")
    public Ticket createTicket(@RequestBody Ticket ticket){
        return ticketBookingService.createTicket(ticket);
    }

    @GetMapping(value = "/ticket/{ticketId}")
    public Optional<Ticket> getTicketById(@PathVariable("ticketId")Integer ticketId){
        return ticketBookingService.getTicketById(ticketId);
    }

    @GetMapping(value = "/alltickets")
    public Iterable<Ticket> getAllBookedTickets(){
        return ticketBookingService.getAllBookedTickets();
    }

    @GetMapping(value = "/email/{email:.+}")
    public Ticket getTicketByEmail(@PathVariable("email")String email){
        return ticketBookingService.getTicketByEmail(email);
    }

    @DeleteMapping(value = "/ticket/{ticketId}")
    public void deleteTicket(@PathVariable("ticketId")Integer ticketId){
        ticketBookingService.deleteTicket(ticketId);
    }

    @PutMapping(value = "/ticket/{email}/newEmail/{newEmail:.+}")
    public Ticket updateTicket(@PathVariable("email")String email, @PathVariable("newEmail")String newEmail){
        return ticketBookingService.updateTicket(email, newEmail);
    }

}
