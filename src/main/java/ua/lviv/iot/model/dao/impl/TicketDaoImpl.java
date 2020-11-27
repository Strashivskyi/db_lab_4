package ua.lviv.iot.model.dao.impl;

import org.hibernate.Session;
import ua.lviv.iot.model.entity.Ticket;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketDaoImpl extends AbstractGenericDaoImpl<Ticket> {
    public TicketDaoImpl() throws SQLException {
        super(Ticket.class);
    }

    @SuppressWarnings("unchecked")
    public List<Ticket> findByClientId(Integer clientId) {
        List<Ticket> ticketsByClientId = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            ticketsByClientId = session.createQuery("from Ticket where client.id = " + clientId)
                    .getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ticketsByClientId;
    }
}