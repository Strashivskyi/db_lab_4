package ua.lviv.iot.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ClientDao<Client> {
    List<Client> findAll() throws SQLException;

    Client findOne(Integer id) throws SQLException;

    void create(Client object) throws SQLException;

    void update(Integer id, Client object) throws SQLException;

    void delete(Integer id) throws SQLException;

}