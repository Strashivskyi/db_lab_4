package ua.lviv.iot.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface AttractionDao<Attraction> {
    List<Attraction> findAll() throws SQLException;

    Attraction findOne(Integer id) throws SQLException;

    void create(Attraction object) throws SQLException;

    void update(Integer id, Attraction object) throws SQLException;

    void delete(Integer id) throws SQLException;

}