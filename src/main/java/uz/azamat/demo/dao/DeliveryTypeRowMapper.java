package uz.azamat.demo.dao;

import org.springframework.jdbc.core.RowMapper;
import uz.azamat.demo.model.DeliveryType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeliveryTypeRowMapper implements RowMapper<DeliveryType> {
    @Override
    public DeliveryType mapRow(ResultSet resultSet, int i) throws SQLException {
        DeliveryType deliveryType = new DeliveryType();
        deliveryType.setId(resultSet.getInt("ID"));
        deliveryType.setName(resultSet.getString("NAME"));
        return deliveryType;
    }
}
