package ua.lviv.iot.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao<Employee> {
    List<Employee> findAll() throws SQLException;

    Employee findOne(Integer id) throws SQLException;

    void create(Employee object) throws SQLException;

    void update(Integer id, Employee object) throws SQLException;

    void delete(Integer id) throws SQLException;

}