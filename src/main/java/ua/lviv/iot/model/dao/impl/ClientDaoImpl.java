package ua.lviv.iot.model.dao.impl;

import ua.lviv.iot.model.dao.AmusementParkDao;
import ua.lviv.iot.model.dao.AttractionDao;
import ua.lviv.iot.model.dao.CityDao;
import ua.lviv.iot.model.dao.ClientDao;
import ua.lviv.iot.model.entity.AmusementPark;
import ua.lviv.iot.model.entity.Attraction;
import ua.lviv.iot.model.entity.City;
import ua.lviv.iot.model.entity.Client;
import ua.lviv.iot.util.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoImpl implements ClientDao<Client> {
    private static final String GET_ALL = "SELECT * FROM amusements_db.client";
    private static final String GET_ONE = "SELECT * FROM amusements_db.client WHERE id=?";
    private static final String CREATE = "INSERT amusements_db.client "
            + "(first_name, last_name, birthday, gender, address, city_id) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE amusements_db.client"
            + " SET first_name=?, last_name=?, birthday=?, gender=?, address=?, city_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM amusements_db.client WHERE id=?";

    @Override
    public List<Client> findAll() {
        List<Client> clients = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Client client = new Client(
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("birthday"),
                        resultSet.getString("gender"),
                        resultSet.getString("address"),
                        resultSet.getInt("city_id")
                );
                clients.add(client);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clients;
    }

    @Override
    public Client findOne(Integer id) {
        Client client = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE)) {

            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                client = new Client(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("birthday"),
                        resultSet.getString("gender"),
                        resultSet.getString("address"),
                        resultSet.getInt("city_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return client;
    }

    @Override
    public void create(Client client) throws SQLException {

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, client.getFirstName());
            statement.setString(2, client.getLastName());
            statement.setString(3, client.getBirthday());
            statement.setString(4, client.getGender());
            statement.setString(5, client.getAddress());
            statement.setInt(6, client.getCityId());


            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void update(Integer id, Client client) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {

            statement.setString(1, client.getFirstName());
            statement.setString(2, client.getLastName());
            statement.setString(3, client.getBirthday());
            statement.setString(4, client.getGender());
            statement.setString(5, client.getAddress());
            statement.setInt(6, client.getCityId());
            statement.setInt(7, id);

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