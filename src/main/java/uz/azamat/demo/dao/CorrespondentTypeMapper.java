package uz.azamat.demo.dao;

import org.springframework.jdbc.core.RowMapper;
import uz.azamat.demo.model.CorrespondentType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CorrespondentTypeMapper implements RowMapper<CorrespondentType> {
    @Override
    public CorrespondentType mapRow(ResultSet resultSet, int i) throws SQLException {
        CorrespondentType correspondentType = new CorrespondentType();
        correspondentType.setId(resultSet.getInt("ID"));
        correspondentType.setName(resultSet.getString("NAME"));
        return correspondentType;
    }
}
