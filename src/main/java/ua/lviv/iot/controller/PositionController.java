package ua.lviv.iot.controller;

import ua.lviv.iot.model.dao.impl.PositionDaoImpl;
import ua.lviv.iot.model.entity.Position;

import java.sql.SQLException;
import java.util.List;

public class PositionController implements AbstractGenericController<Position> {
    PositionDaoImpl dao = new PositionDaoImpl();

    @Override
    public List<Position> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Position findOne(Integer id) throws SQLException {
        return dao.findOne(id);
    }

    @Override
    public void create(Position entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Position entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);

    }
}
