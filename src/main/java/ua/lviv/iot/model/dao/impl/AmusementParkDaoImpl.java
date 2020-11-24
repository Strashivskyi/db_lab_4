package ua.lviv.iot.model.dao.impl;

import ua.lviv.iot.model.dao.AmusementParkDao;
import ua.lviv.iot.model.entity.AmusementPark;
import ua.lviv.iot.util.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AmusementParkDaoImpl implements AmusementParkDao<AmusementPark> {
    private static final String GET_ALL = "SELECT * FROM amusements_db.amusement_park";
    private static final String GET_ONE = "SELECT * FROM amusements_db.amusement_park WHERE id=?";
    private static final String CREATE = "INSERT amusements_db.amusement_park "
            + "(capacity, adress, name, city_id) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE amusements_db.amusement_park"
            + " SET capacity=?, adress=?, name=?, city_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM amusements_db.amusement_park WHERE id=?";

    @Override
    public List<AmusementPark> findAll() {
        List<AmusementPark> amusementParks = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                AmusementPark amusementPark = new AmusementPark(
                        resultSet.getInt("capacity"),
                        resultSet.getString("adress"),
                        resultSet.getString("name"),
                        resultSet.getInt("city_id")

                );
                amusementParks.add(amusementPark);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amusementParks;
    }

    @Override
    public AmusementPark findOne(Integer id) {
        AmusementPark amusementPark = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE)) {

            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                amusementPark = new AmusementPark(
                        resultSet.getInt("id"),
                        resultSet.getInt("capacity"),
                        resultSet.getString("adress"),
                        resultSet.getString("name"),
                        resultSet.getInt("city_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amusementPark;
    }

    @Override
    public void create(AmusementPark amusementPark) throws SQLException {

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {

            statement.setInt(1, amusementPark.getCapacity());
            statement.setString(2, String.valueOf(amusementPark.getAddress()));
            statement.setString(3, String.valueOf(amusementPark.getName()));
            statement.setInt(4, amusementPark.getCityId());

            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void update(Integer id, AmusementPark amusementPark) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {

            statement.setInt(1, amusementPark.getCapacity());
            statement.setString(2, amusementPark.getAddress());
            statement.setString(3, amusementPark.getName());
            statement.setInt(4, amusementPark.getCityId());
            statement.setInt(5, id);

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
