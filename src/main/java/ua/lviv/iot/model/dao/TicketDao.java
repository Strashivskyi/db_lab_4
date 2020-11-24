package ua.lviv.iot.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface TicketDao<Ticket> {
    List<Ticket> findAll() throws SQLException;

    Ticket findOne(Integer id) throws SQLException;

    void create(Ticket object) throws SQLException;

    void update(Integer id, Ticket object) throws SQLException;

    void delete(Integer id) throws SQLException;

}