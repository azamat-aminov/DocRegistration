package uz.azamat.demo.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uz.azamat.demo.model.CorrespondentType;

import java.util.List;
@Repository
public class CorrespondentTypeImpl implements CorrespondentTypeDao {
    JdbcTemplate jdbcTemplate;

    public CorrespondentTypeImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<CorrespondentType> getAllCorrespondent() {
        String query = "SELECT ID , NAME FROM ref_data WHERE REF_TYPE_ID =(SELECT ID FROM ref_types WHERE NAME = 'Correspondent_type')";
        return jdbcTemplate.query(query, new CorrespondentTypeMapper());
    }
}
