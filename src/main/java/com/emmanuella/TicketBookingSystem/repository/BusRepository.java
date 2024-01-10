package com.emmanuella.TicketBookingSystem.repository;

import com.emmanuella.TicketBookingSystem.models.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BusRepository extends JpaRepository<Bus, Integer> {
    Optional<Bus> findBySourceStationAndDestStation(String sourceStation, String destStation);
}
