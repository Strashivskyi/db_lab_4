package ua.lviv.iot.model.dao.impl;

import ua.lviv.iot.model.dao.AmusementParkDao;
import ua.lviv.iot.model.dao.AttractionDao;
import ua.lviv.iot.model.dao.CityDao;
import ua.lviv.iot.model.dao.RegionDao;
import ua.lviv.iot.model.entity.AmusementPark;
import ua.lviv.iot.model.entity.Attraction;
import ua.lviv.iot.model.entity.Region;
import ua.lviv.iot.util.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegionDaoImpl implements RegionDao<Region> {
    private static final String GET_ALL = "SELECT * FROM amusements_db.region";
    private static final String GET_ONE = "SELECT * FROM amusements_db.region WHERE id=?";
    private static final String CREATE = "INSERT amusements_db.region "
            + "(name) VALUES (?)";
    private static final String UPDATE = "UPDATE amusements_db.region"
            + " SET name=? WHERE id=?";
    private static final String DELETE = "DELETE FROM amusements_db.region WHERE id=?";

    @Override
    public List<Region> findAll() {
        List<Region> regions = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Region region = new Region(
                        resultSet.getString("name")
                );
                regions.add(region);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return regions;
    }

    @Override
    public Region findOne(Integer id) {
        Region region = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE)) {

            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                region = new Region(
                        resultSet.getInt("id"),
                        resultSet.getString("name")

                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return region;
    }

    @Override
    public void create(Region region) throws SQLException {

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {

            statement.setString(1, region.getName());


            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void update(Integer id, Region region) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {

            statement.setString(1, region.getName());
            statement.setInt(2, id);

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