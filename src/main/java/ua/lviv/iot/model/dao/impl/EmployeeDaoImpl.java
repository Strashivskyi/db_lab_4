package ua.lviv.iot.model.dao.impl;

import ua.lviv.iot.model.dao.AmusementParkDao;
import ua.lviv.iot.model.dao.EmployeeDao;
import ua.lviv.iot.model.entity.AmusementPark;
import ua.lviv.iot.model.entity.Employee;
import ua.lviv.iot.util.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao<Employee> {
    private static final String GET_ALL = "SELECT * FROM amusements_db.worker";
    private static final String GET_ONE = "SELECT * FROM amusements_db.worker WHERE id=?";
    private static final String CREATE = "INSERT amusements_db.worker "
            + "(phone_number, email, birthday, gender, position_id, first_name, last_name, city_id, amusement_park_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE amusements_db.worker"
            + " SET phone_number=?, email=?, birthday=?, gender=?, position_id=?, first_name=?, last_name=?, city_id=?, amusement_park_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM amusements_db.worker WHERE id=?";

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee(
                        resultSet.getString("phone_number"),
                        resultSet.getString("email"),
                        resultSet.getString("birthday"),
                        resultSet.getString("gender"),
                        resultSet.getInt("position_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getInt("city_id"),
                        resultSet.getInt("amusement_park_id")


                );
                employees.add(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public Employee findOne(Integer id) {
        Employee employee = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE)) {

            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                employee = new Employee(
                        resultSet.getInt("id"),
                        resultSet.getString("phone_number"),
                        resultSet.getString("email"),
                        resultSet.getString("birthday"),
                        resultSet.getString("gender"),
                        resultSet.getInt("position_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getInt("city_id"),
                        resultSet.getInt("amusement_park_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void create(Employee employee) throws SQLException {

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, employee.getPhoneNumber());
            statement.setString(2, employee.getEmail());
            statement.setString(3, employee.getBirthday());
            statement.setString(4, employee.getGender());
            statement.setInt(5, employee.getPositionId());
            statement.setString(6, employee.getFirstName());
            statement.setString(7, employee.getLastName());
            statement.setInt(8, employee.getCityId());
            statement.setInt(9, employee.getAmusementParkId());


            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void update(Integer id, Employee employee) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {

            statement.setString(1, employee.getPhoneNumber());
            statement.setString(2, employee.getEmail());
            statement.setString(3, employee.getBirthday());
            statement.setString(4, employee.getGender());
            statement.setInt(5, employee.getPositionId());
            statement.setString(6, employee.getFirstName());
            statement.setString(7, employee.getLastName());
            statement.setInt(8, employee.getCityId());
            statement.setInt(9, employee.getAmusementParkId());
            statement.setInt(10, id);

            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(DELETE)) {
            statement.setInt(1, id);
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
