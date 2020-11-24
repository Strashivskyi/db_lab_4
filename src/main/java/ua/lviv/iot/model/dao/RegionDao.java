package ua.lviv.iot.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface RegionDao<Region> {
    List<Region> findAll() throws SQLException;

    Region findOne(Integer id) throws SQLException;

    void create(Region object) throws SQLException;

    void update(Integer id, Region object) throws SQLException;

    void delete(Integer id) throws SQLException;

}