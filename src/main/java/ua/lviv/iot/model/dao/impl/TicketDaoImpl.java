package ua.lviv.iot.model.dao.impl;

import ua.lviv.iot.model.dao.AmusementParkDao;
import ua.lviv.iot.model.dao.TicketDao;
import ua.lviv.iot.model.entity.Ticket;
import ua.lviv.iot.util.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketDaoImpl implements TicketDao<Ticket> {
    private static final String GET_ALL = "SELECT * FROM amusements_db.ticket";
    private static final String GET_ONE = "SELECT * FROM amusements_db.ticket WHERE id=?";
    private static final String CREATE = "INSERT amusements_db.ticket "
            + "(arrival_time, departure_time, people_number, kids_number, price_in_USD, client_id, amusement_park_id, payment_time) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE amusements_db.ticket"
            + " SET arrival_time=?, departure_time=?, people_number=?, kids_number=?, price_in_USD=?, client_id=?, amusement_park_id=?, payment_time=? WHERE id=?";
    private static final String DELETE = "DELETE FROM amusements_db.ticket WHERE id=?";

    @Override
    public List<Ticket> findAll() {
        List<Ticket> tickets = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Ticket ticket = new Ticket(
                        resultSet.getString("arrival_time"),
                        resultSet.getString("departure_time"),
                        resultSet.getInt("people_number"),
                        resultSet.getInt("kids_number"),
                        resultSet.getInt("price_in_USD"),
                        resultSet.getInt("client_id"),
                        resultSet.getInt("amusement_park_id"),
                        resultSet.getString("payment_time")

                );
                tickets.add(ticket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tickets;
    }

    @Override
    public Ticket findOne(Integer id) {
        Ticket ticket = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE)) {

            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ticket = new Ticket(
                        resultSet.getInt("id"),
                        resultSet.getString("arrival_time"),
                        resultSet.getString("departure_time"),
                        resultSet.getInt("people_number"),
                        resultSet.getInt("kids_number"),
                        resultSet.getInt("price_in_USD"),
                        resultSet.getInt("client_id"),
                        resultSet.getInt("amusement_park_id"),
                        resultSet.getString("payment_time")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ticket;
    }

    @Override
    public void create(Ticket ticket) throws SQLException {

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, ticket.getArrivalTime());
            statement.setString(2, ticket.getDepartureTime());
            statement.setInt(3, ticket.getPeopleNumber());
            statement.setInt(4, ticket.getKidsNumber());
            statement.setInt(5, ticket.getPriceInUSD());
            statement.setInt(6, ticket.getClientId());
            statement.setInt(7, ticket.getAmusementParkId());
            statement.setString(8, ticket.getPaymentTime());

            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void update(Integer id, Ticket ticket) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {

            statement.setString(1, ticket.getArrivalTime());
            statement.setString(2, ticket.getDepartureTime());
            statement.setInt(3, ticket.getPeopleNumber());
            statement.setInt(4, ticket.getKidsNumber());
            statement.setInt(5, ticket.getPriceInUSD());
            statement.setInt(6, ticket.getClientId());
            statement.setInt(7, ticket.getAmusementParkId());
            statement.setString(8, ticket.getPaymentTime());
            statement.setInt(9, id);

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
