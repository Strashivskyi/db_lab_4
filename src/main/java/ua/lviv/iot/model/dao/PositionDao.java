package ua.lviv.iot.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface PositionDao<Position> {
    List<Position> findAll() throws SQLException;

    Position findOne(Integer id) throws SQLException;

    void create(Position object) throws SQLException;

    void update(Integer id, Position object) throws SQLException;

    void delete(Integer id) throws SQLException;

}