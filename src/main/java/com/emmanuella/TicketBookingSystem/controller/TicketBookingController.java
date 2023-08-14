package com.emmanuella.TicketBookingSystem.controller;

import com.emmanuella.TicketBookingSystem.models.Ticket;
import com.emmanuella.TicketBookingSystem.service.TicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/tickets")
@PreAuthorize("hasRole('ADMIN') or (hasRole('USER')")
public class TicketBookingController {
    @Autowired
    private TicketBookingService ticketBookingService;

    @PostMapping()
    public Ticket createTicket(@RequestBody Ticket ticket){
        return ticketBookingService.createTicket(ticket);
    }

    @GetMapping("/{ticketId}")
    public Optional<Ticket> getTicketById(@PathVariable String ticketId){
        return ticketBookingService.getTicketById(ticketId);
    }

    @GetMapping()
    public Iterable<Ticket> getAllBookedTickets(){
        return ticketBookingService.getAllBookedTickets();
    }

    @GetMapping("/email/{email:.+}")
    public Ticket getTicketByEmail(@PathVariable String email){
        return ticketBookingService.getTicketByEmail(email);
    }

    @DeleteMapping("/{ticketId}")
    public void deleteTicket(@PathVariable String ticketId){
        ticketBookingService.deleteTicket(ticketId);
    }

    @PutMapping("/{ticketId}/newEmail/{newEmail:.+}")
    public Ticket updateTicket(@PathVariable String ticketId, @PathVariable String newEmail){
        return ticketBookingService.updateTicket(ticketId, newEmail);
    }

}
