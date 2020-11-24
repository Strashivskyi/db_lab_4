package ua.lviv.iot.model.dao.impl;

import ua.lviv.iot.model.dao.PositionDao;
import ua.lviv.iot.model.entity.Position;
import ua.lviv.iot.util.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionDaoImpl implements PositionDao<Position> {
    private static final String GET_ALL = "SELECT * FROM amusements_db.position";
    private static final String GET_ONE = "SELECT * FROM amusements_db.position WHERE id=?";
    private static final String CREATE = "INSERT amusements_db.position "
            + "(name, description) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE amusements_db.position"
            + " SET name=?, description=? WHERE id=?";
    private static final String DELETE = "DELETE FROM amusements_db.position WHERE id=?";

    @Override
    public List<Position> findAll() {
        List<Position> positions = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Position position = new Position(
                        resultSet.getString("name"),
                        resultSet.getString("description")
                );
                positions.add(position);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return positions;
    }

    @Override
    public Position findOne(Integer id) {
        Position position = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE)) {

            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                position = new Position(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return position;
    }

    @Override
    public void create(Position position) throws SQLException {

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {

            statement.setString(1, position.getName());
            statement.setString(2, position.getDescription());


            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void update(Integer id, Position position) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {

            statement.setString(1, position.getName());
            statement.setString(2, position.getDescription());
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