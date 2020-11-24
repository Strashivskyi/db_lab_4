package ua.lviv.iot.controller;

import ua.lviv.iot.model.dao.impl.AttractionDaoImpl;
import ua.lviv.iot.model.entity.Attraction;

import java.sql.SQLException;
import java.util.List;

public class AttractionController implements AbstractGenericController<Attraction> {
    AttractionDaoImpl dao = new AttractionDaoImpl();

    @Override
    public List<Attraction> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Attraction findOne(Integer id) throws SQLException {
        return dao.findOne(id);
    }

    @Override
    public void create(Attraction entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Attraction entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);

    }
}