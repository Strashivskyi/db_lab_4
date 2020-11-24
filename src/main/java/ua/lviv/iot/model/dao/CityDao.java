package ua.lviv.iot.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface CityDao<City> {
    List<City> findAll() throws SQLException;

    City findOne(Integer id) throws SQLException;

    void create(City object) throws SQLException;

    void update(Integer id, City object) throws SQLException;

    void delete(Integer id) throws SQLException;

}