package ua.lviv.iot.model.dao.impl;

import ua.lviv.iot.model.dao.AmusementParkDao;
import ua.lviv.iot.model.dao.AttractionDao;
import ua.lviv.iot.model.dao.CityDao;
import ua.lviv.iot.model.entity.AmusementPark;
import ua.lviv.iot.model.entity.Attraction;
import ua.lviv.iot.model.entity.City;
import ua.lviv.iot.util.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDaoImpl implements CityDao<City> {
    private static final String GET_ALL = "SELECT * FROM amusements_db.city";
    private static final String GET_ONE = "SELECT * FROM amusements_db.city WHERE id=?";
    private static final String CREATE = "INSERT amusements_db.city "
            + "(region_id, name) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE amusements_db.city"
            + " SET region_id=?, name=? WHERE id=?";
    private static final String DELETE = "DELETE FROM amusements_db.city WHERE id=?";

    @Override
    public List<City> findAll() {
        List<City> cities = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                City city = new City(
                        resultSet.getInt("region_id"),
                        resultSet.getString("name")
                );
                cities.add(city);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cities;
    }

    @Override
    public City findOne(Integer id) {
        City city = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE)) {

            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                city = new City(
                        resultSet.getInt("id"),
                        resultSet.getInt("region_id"),
                        resultSet.getString("name")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return city;
    }

    @Override
    public void create(City city) throws SQLException {

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {

            statement.setInt(1, city.getRegionId());
            statement.setString(2, String.valueOf(city.getName()));


            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void update(Integer id, City city) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {

            statement.setInt(1, city.getRegionId());
            statement.setString(2, city.getName());
            statement.setInt(3, id);

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