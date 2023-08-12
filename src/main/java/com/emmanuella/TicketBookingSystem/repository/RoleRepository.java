package com.emmanuella.TicketBookingSystem.repository;

import com.emmanuella.TicketBookingSystem.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);
}
