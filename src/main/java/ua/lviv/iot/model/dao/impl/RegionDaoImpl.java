package ua.lviv.iot.model.dao.impl;
import ua.lviv.iot.model.entity.Position;
import ua.lviv.iot.model.entity.Region;

import java.sql.SQLException;


public class RegionDaoImpl extends AbstractGenericDaoImpl<Region> {
    public RegionDaoImpl() throws SQLException {
        super(Region.class);
    }
}