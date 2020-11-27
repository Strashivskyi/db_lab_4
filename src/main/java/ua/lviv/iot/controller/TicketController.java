package ua.lviv.iot.controller;

import ua.lviv.iot.model.dao.impl.TicketDaoImpl;
import ua.lviv.iot.model.entity.Ticket;

import java.sql.SQLException;
import java.util.List;

public class TicketController implements AbstractGenericController<Ticket> {
    TicketDaoImpl dao = new TicketDaoImpl();

    public TicketController() throws SQLException {
    }

    @Override
    public List<Ticket> findAll() throws SQLException {
        return (List<Ticket>) dao.findAll();
    }

    @Override
    public Ticket findOne(Integer id) throws SQLException {
        return dao.findOne(id);
    }

    @Override
    public void create(Ticket entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Ticket entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);

    }
}
