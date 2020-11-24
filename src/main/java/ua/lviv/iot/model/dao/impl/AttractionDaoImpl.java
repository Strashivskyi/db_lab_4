package ua.lviv.iot.model.dao.impl;

import ua.lviv.iot.model.dao.AmusementParkDao;
import ua.lviv.iot.model.dao.AttractionDao;
import ua.lviv.iot.model.entity.AmusementPark;
import ua.lviv.iot.model.entity.Attraction;
import ua.lviv.iot.util.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttractionDaoImpl implements AttractionDao<Attraction> {
    private static final String GET_ALL = "SELECT * FROM amusements_db.attraction";
    private static final String GET_ONE = "SELECT * FROM amusements_db.attraction WHERE id=?";
    private static final String CREATE = "INSERT amusements_db.attraction "
            + "(name, description, capacity, amusement_park_id, minimum_age) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE amusements_db.attraction"
            + " SET name=?, description=?, capacity=?, amusement_park_id=?, minimum_age=? WHERE id=?";
    private static final String DELETE = "DELETE FROM amusements_db.attraction WHERE id=?";

    @Override
    public List<Attraction> findAll() {
        List<Attraction> attractions = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Attraction attraction = new Attraction(
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getInt("capacity"),
                        resultSet.getInt("amusement_park_id"),
                        resultSet.getInt("minimum_age")

                );
                attractions.add(attraction);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return attractions;
    }

    @Override
    public Attraction findOne(Integer id) {
        Attraction attraction = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE)) {

            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                attraction = new Attraction(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getInt("capacity"),
                        resultSet.getInt("amusement_park_id"),
                        resultSet.getInt("minimum_age")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return attraction;
    }

    @Override
    public void create(Attraction attraction) throws SQLException {

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {

            statement.setString(1, attraction.getName());
            statement.setString(2, attraction.getDescription());
            statement.setInt(3, attraction.getCapacity());
            statement.setInt(4, attraction.getAmusementParkId());
            statement.setInt(5, attraction.getMinimumAge());


            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void update(Integer id, Attraction attraction) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {

            statement.setString(1, attraction.getName());
            statement.setString(2, attraction.getDescription());
            statement.setInt(3, attraction.getCapacity());
            statement.setInt(4, attraction.getAmusementParkId());
            statement.setInt(5, attraction.getMinimumAge());
            statement.setInt(6, id);

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