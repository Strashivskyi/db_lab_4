package ua.lviv.iot.controller;

import ua.lviv.iot.model.dao.impl.CityDaoImpl;
import ua.lviv.iot.model.entity.City;

import java.sql.SQLException;
import java.util.List;

public class CityController implements AbstractGenericController<City> {
    CityDaoImpl dao = new CityDaoImpl();

    @Override
    public List<City> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public City findOne(Integer id) throws SQLException {
        return dao.findOne(id);
    }

    @Override
    public void create(City entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, City entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);

    }
}