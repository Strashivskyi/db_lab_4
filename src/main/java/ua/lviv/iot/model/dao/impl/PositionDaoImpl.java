package ua.lviv.iot.model.dao.impl;
import ua.lviv.iot.model.entity.Position;

import java.sql.SQLException;


public class PositionDaoImpl extends AbstractGenericDaoImpl<Position> {
    public PositionDaoImpl() throws SQLException {
        super(Position.class);
    }
}