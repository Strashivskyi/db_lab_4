package ua.lviv.iot.model.dao.impl;

import org.hibernate.Session;
import ua.lviv.iot.model.entity.Client;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoImpl extends AbstractGenericDaoImpl<Client> {
    public ClientDaoImpl() throws SQLException {
        super(Client.class);
    }

    @SuppressWarnings("unchecked")
    public List<Client> findByCityId(Integer cityId) {
        List<Client> clientsByCityId = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            clientsByCityId = session.createQuery("from Client where city.id = " + cityId)
                    .getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clientsByCityId;
    }
}
