package com.emmanuella.TicketBookingSystem.controller;

import com.emmanuella.TicketBookingSystem.dto.BusDto;
import com.emmanuella.TicketBookingSystem.models.Bus;
import com.emmanuella.TicketBookingSystem.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/buses")
@PreAuthorize("hasRole('ADMIN')")
public class BusController {
    @Autowired
    private BusService busService;

    @GetMapping()
    public ResponseEntity<Iterable> getAllBuses(){
            return new ResponseEntity<>(busService.allBuses(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional> getBus(@PathVariable Integer id){
            return new ResponseEntity<>(busService.getBusById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Bus> newBus(@RequestBody Bus bus){
        return new ResponseEntity<>(busService.addBus(bus), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public void deleteBus(@PathVariable Integer id){
        busService.deleteBus(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bus> updateBus(@PathVariable Integer id, @RequestBody BusDto busDto){
        return new ResponseEntity<>(busService.updateBus(id, busDto), HttpStatus.OK);
    }
}
