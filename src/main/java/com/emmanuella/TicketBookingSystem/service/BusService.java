package com.emmanuella.TicketBookingSystem.service;

import com.emmanuella.TicketBookingSystem.dto.BusDto;
import com.emmanuella.TicketBookingSystem.models.Bus;
import com.emmanuella.TicketBookingSystem.models.Ticket;
import com.emmanuella.TicketBookingSystem.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BusService {
    @Autowired
    private BusRepository busRepository;


    public Bus addBus(Bus bus){
        return busRepository.save(bus);
    }

    public Optional<Bus> getBusById(Integer id){
        return busRepository.findById(id);
    }

    public Iterable<Bus> allBuses(){
        return busRepository.findAll();
    }

    public void deleteBus(Integer id){
        busRepository.deleteById(id);
    }

    public Bus updateBus(Integer id, BusDto busDto){
        Optional<Bus> busFromDb = busRepository.findById(id);
        if(busFromDb.isPresent()) {
            Bus bus = busFromDb.get();
            bus.setSourceStation(busDto.getSourceStation());
            bus.setDestStation(busDto.getDestStation());
            return busRepository.save(bus);
        }
            return null;
    }
}
