package ua.lviv.iot.controller;

import ua.lviv.iot.model.dao.impl.EmployeeDaoImpl;
import ua.lviv.iot.model.entity.Employee;

import java.sql.SQLException;
import java.util.List;

public class EmployeeController implements AbstractGenericController<Employee> {
    EmployeeDaoImpl dao = new EmployeeDaoImpl();

    public EmployeeController() throws SQLException {
    }

    @Override
    public List<Employee> findAll() throws SQLException {
        return (List<Employee>) dao.findAll();
    }

    @Override
    public Employee findOne(Integer id) throws SQLException {
        return dao.findOne(id);
    }

    @Override
    public void create(Employee entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Employee entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);

    }
}
