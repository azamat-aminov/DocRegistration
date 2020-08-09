package uz.azamat.demo.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uz.azamat.demo.model.DeliveryType;

import java.util.List;

@Repository
public class DeliveryTypeImpl implements DeliveryTypeDao {
    JdbcTemplate jdbcTemplate;

    public DeliveryTypeImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<DeliveryType> getAllDelivery() {
        String query = "SELECT ID , NAME FROM ref_data WHERE REF_TYPE_ID = (SELECT ID FROM ref_types WHERE NAME ='Delivery_type')";
        return jdbcTemplate.query(query, new DeliveryTypeRowMapper());
    }
}
