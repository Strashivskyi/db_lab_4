package ua.lviv.iot.controller;

import ua.lviv.iot.model.dao.impl.RegionDaoImpl;
import ua.lviv.iot.model.entity.Region;

import java.sql.SQLException;
import java.util.List;

public class RegionController implements AbstractGenericController<Region> {
    RegionDaoImpl dao = new RegionDaoImpl();

    public RegionController() throws SQLException {
    }

    @Override
    public List<Region> findAll() throws SQLException {
        return (List<Region>) dao.findAll();
    }

    @Override
    public Region findOne(Integer id) throws SQLException {
        return dao.findOne(id);
    }

    @Override
    public void create(Region entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Region entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);

    }
}
