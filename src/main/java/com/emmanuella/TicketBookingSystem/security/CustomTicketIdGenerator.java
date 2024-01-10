package com.emmanuella.TicketBookingSystem.security;

import com.emmanuella.TicketBookingSystem.models.Bus;
import com.emmanuella.TicketBookingSystem.models.Ticket;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.Optional;

public class CustomTicketIdGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor  session, Object obj) throws HibernateException{
        Ticket ticket = (Ticket) obj;
        long timestamp = System.currentTimeMillis();
        Integer busId = ticket.getBus().getId();;
        String sourceStation = ticket.getSourceStation();
        System.out.println(sourceStation);
        String destStation = ticket.getDestStation();
        System.out.println(destStation);

        //Integer matchingBus = ticket.getBus().getId();
        return timestamp + "-" + busId;
    }
}
