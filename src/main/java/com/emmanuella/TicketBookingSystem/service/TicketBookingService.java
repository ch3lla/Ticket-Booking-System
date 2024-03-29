package com.emmanuella.TicketBookingSystem.service;


import com.emmanuella.TicketBookingSystem.dto.TicketDto;
import com.emmanuella.TicketBookingSystem.models.Bus;
import com.emmanuella.TicketBookingSystem.models.Ticket;
import com.emmanuella.TicketBookingSystem.repository.BusRepository;
import com.emmanuella.TicketBookingSystem.repository.TicketBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketBookingService {

    @Autowired
    private TicketBookingRepository ticketBookingRepository;
    @Autowired
    private BusRepository busRepository;

    public Ticket createTicket(TicketDto ticketDto){
        Ticket ticket = new Ticket();
        ticket.setPassengerName(ticketDto.getPassengerName());
        ticket.setDateOfDeparture(ticketDto.getDateOfDeparture());
        ticket.setSourceStation(ticketDto.getSourceStation());
        ticket.setDestStation(ticketDto.getDestStation());
        ticket.setEmail(ticketDto.getEmail());
        Optional<Bus> optionalBus= busRepository.findBySourceStationAndDestStation(ticketDto.getSourceStation(), ticketDto.getDestStation());
        optionalBus.ifPresent(ticket::setBus);
        return ticketBookingRepository.save(ticket);
    }

    public Optional<Ticket> getTicketById(String ticketId){
        return ticketBookingRepository.findById(ticketId);
    }

    public Iterable<Ticket> getAllBookedTickets(){
        return ticketBookingRepository.findAll();
    }

    public void deleteTicket(String ticketId){
        ticketBookingRepository.deleteById(ticketId);
    }

    public Ticket updateTicket(String ticketId, String newEmail){
        Optional<Ticket> ticketFromDb = ticketBookingRepository.findById(ticketId);
        if(ticketFromDb.isPresent()){
            Ticket ticket = ticketFromDb.get();
            ticket.setEmail(newEmail);
            return ticketBookingRepository.save(ticket);
        }
        return null;
    }

    public Ticket getTicketByEmail(String email){
        return ticketBookingRepository.findByEmail(email);
    }

}
