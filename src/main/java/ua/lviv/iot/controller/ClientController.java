package ua.lviv.iot.controller;

import ua.lviv.iot.model.dao.impl.ClientDaoImpl;
import ua.lviv.iot.model.entity.Client;

import java.sql.SQLException;
import java.util.List;

public class ClientController implements AbstractGenericController<Client> {
    ClientDaoImpl dao = new ClientDaoImpl();

    @Override
    public List<Client> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Client findOne(Integer id) throws SQLException {
        return dao.findOne(id);
    }

    @Override
    public void create(Client entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Client entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);

    }
}
