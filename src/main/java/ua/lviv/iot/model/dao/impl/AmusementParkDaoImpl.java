package ua.lviv.iot.model.dao.impl;

import org.hibernate.Session;
import ua.lviv.iot.model.entity.AmusementPark;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AmusementParkDaoImpl extends AbstractGenericDaoImpl<AmusementPark> {
    public AmusementParkDaoImpl() throws SQLException {
        super(AmusementPark.class);
    }

    @SuppressWarnings("unchecked")
    public List<AmusementPark> findByCityId(Integer cityId) {
        List<AmusementPark> amusementParksByCityId = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            amusementParksByCityId = session.createQuery("from AmusementPark where city.id = " + cityId)
                    .getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amusementParksByCityId;
    }
}
