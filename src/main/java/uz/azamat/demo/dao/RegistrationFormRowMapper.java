package uz.azamat.demo.dao;

import org.springframework.jdbc.core.RowMapper;
import uz.azamat.demo.model.RegistrationForm;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistrationFormRowMapper implements RowMapper<RegistrationForm> {
    @Override
    public RegistrationForm mapRow(ResultSet resultSet, int i) throws SQLException {
        RegistrationForm registrationForm = new RegistrationForm();

        registrationForm.setRegisterNumber(resultSet.getString("REGISTER_NUM"));
        registrationForm.setRegisterDate(resultSet.getString("REGISTER_DATE"));
        registrationForm.setLeaveRegisterNumber(resultSet.getString("OUTGOING_NUM"));
        registrationForm.setLeaveDate(resultSet.getString("OUTGOING_DATE"));
        registrationForm.setFormDelivery(resultSet.getString("DELIVERY_TYPE"));
        registrationForm.setCorrespondent(resultSet.getString("CORRESPONDENT"));
        registrationForm.setTopic(resultSet.getString("THEME"));
        registrationForm.setDescription(resultSet.getString("DESCRIPTION"));
        registrationForm.setExecutionPeriod(resultSet.getString("DUE_DATE"));
        registrationForm.setAccess(resultSet.getInt("ACCESS"));
        registrationForm.setControl(resultSet.getInt("CONTROL"));
        registrationForm.setFileName(resultSet.getString("FILE_NAME"));
        registrationForm.setFileRelPath(resultSet.getString("FILE_REL_PATH"));

        return registrationForm;
    }
}
