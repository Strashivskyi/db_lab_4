package ua.lviv.iot.model.dao.impl;

import org.hibernate.Session;
import ua.lviv.iot.model.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl extends AbstractGenericDaoImpl<Employee> {
    public EmployeeDaoImpl() throws SQLException {
        super(Employee.class);
    }

    @SuppressWarnings("unchecked")
    public List<Employee> findByPositionId(Integer positionId) {
        List<Employee> employeesByPositionId = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            employeesByPositionId = session.createQuery("from Employee where position.id = " + positionId)
                    .getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeesByPositionId;
    }
}
