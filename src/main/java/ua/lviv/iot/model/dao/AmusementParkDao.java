package ua.lviv.iot.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface AmusementParkDao<AmusementPark> {
    List<AmusementPark> findAll() throws SQLException;

    AmusementPark findOne(Integer id) throws SQLException;

    void create(AmusementPark object) throws SQLException;

    void update(Integer id, AmusementPark object) throws SQLException;

    void delete(Integer id) throws SQLException;

}
