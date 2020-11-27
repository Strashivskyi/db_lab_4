package ua.lviv.iot.model.dao.impl;

import org.hibernate.Session;
import ua.lviv.iot.model.entity.City;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDaoImpl extends AbstractGenericDaoImpl<City> {
    public CityDaoImpl() throws SQLException {
        super(City.class);
    }

    @SuppressWarnings("unchecked")
    public List<City> findByRegionId(Integer regionId) {
        List<City> citiesByRegionId = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            citiesByRegionId = session.createQuery("from City where region.id = " + regionId)
                    .getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return citiesByRegionId;
    }
}
