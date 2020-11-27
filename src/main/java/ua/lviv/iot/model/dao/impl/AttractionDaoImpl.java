package ua.lviv.iot.model.dao.impl;

import org.hibernate.Session;
import ua.lviv.iot.model.entity.Attraction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttractionDaoImpl extends AbstractGenericDaoImpl<Attraction> {
    public AttractionDaoImpl() throws SQLException {
        super(Attraction.class);
    }

    @SuppressWarnings("unchecked")
    public List<Attraction> findByAmusementParkId(Integer amusementParkId) {
        List<Attraction> attractionsByAmusementParkId = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            attractionsByAmusementParkId = session.createQuery("from Attraction where amusementPark.id = " + amusementParkId)
                    .getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return attractionsByAmusementParkId;
    }
}
