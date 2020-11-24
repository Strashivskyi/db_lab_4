package ua.lviv.iot.controller;

import ua.lviv.iot.model.dao.impl.AmusementParkDaoImpl;
import ua.lviv.iot.model.entity.AmusementPark;

import java.sql.SQLException;
import java.util.List;

public class AmusementParkController implements AbstractGenericController<AmusementPark> {
    AmusementParkDaoImpl dao = new AmusementParkDaoImpl();

    @Override
    public List<AmusementPark> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public AmusementPark findOne(Integer id) throws SQLException {
        return dao.findOne(id);
    }

    @Override
    public void create(AmusementPark entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, AmusementPark entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);

    }
}
