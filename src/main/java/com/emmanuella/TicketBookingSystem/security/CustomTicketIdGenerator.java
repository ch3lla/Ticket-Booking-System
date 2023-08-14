package com.emmanuella.TicketBookingSystem.security;

import com.emmanuella.TicketBookingSystem.models.Ticket;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

public class CustomTicketIdGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor  session, Object obj) throws HibernateException{
        Ticket ticket = (Ticket) obj;
        long timestamp = System.currentTimeMillis();
        String busId = String.valueOf(ticket.getBus().get(0).getId());

        return timestamp + "-" + busId;
    }
}
