package com.emmanuella.TicketBookingSystem.controller;

import com.emmanuella.TicketBookingSystem.dto.TicketDto;
import com.emmanuella.TicketBookingSystem.models.Ticket;
import com.emmanuella.TicketBookingSystem.service.TicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/tickets")
public class TicketBookingController {
    @Autowired
    private TicketBookingService ticketBookingService;

    @PostMapping()
    public ResponseEntity<Ticket> createTicket(@RequestBody TicketDto ticketDto){
        return new ResponseEntity<>(ticketBookingService.createTicket(ticketDto), HttpStatus.CREATED);
    }

    @GetMapping("/{ticketId}")
    public ResponseEntity<Optional> getTicketById(@PathVariable String ticketId){
        return new ResponseEntity<>(ticketBookingService.getTicketById(ticketId), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Iterable> getAllBookedTickets(){
        return new ResponseEntity<>(ticketBookingService.getAllBookedTickets(), HttpStatus.OK);
    }

    @GetMapping("/email/{email:.+}")
    public ResponseEntity<Ticket> getTicketByEmail(@PathVariable String email){
        return new ResponseEntity<>(ticketBookingService.getTicketByEmail(email), HttpStatus.OK);
    }

    @DeleteMapping("/{ticketId}")
    public void deleteTicket(@PathVariable String ticketId){
        ticketBookingService.deleteTicket(ticketId);
    }

    @PutMapping("/{ticketId}/newEmail/{newEmail:.+}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable String ticketId, @PathVariable String newEmail){
        return new ResponseEntity<>(ticketBookingService.updateTicket(ticketId, newEmail), HttpStatus.OK);
    }

}
