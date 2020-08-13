package uz.azamat.demo.dao;

import org.springframework.jdbc.core.RowMapper;
import uz.azamat.demo.model.IncomingDocuments;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistrationFormRowMapper implements RowMapper<IncomingDocuments> {
    @Override
    public IncomingDocuments mapRow(ResultSet resultSet, int i) throws SQLException {
        IncomingDocuments registrationForm = new IncomingDocuments();
        registrationForm.setId(resultSet.getInt("ID"));
        registrationForm.setRegisterNumber(resultSet.getString("REGISTER_NUM"));
        registrationForm.setRegisterDate(resultSet.getDate("REGISTER_DATE"));
        registrationForm.setOutgoingNumber(resultSet.getString("OUTGOING_NUM"));
        registrationForm.setOutgoingDate(resultSet.getDate("OUTGOING_DATE"));
        registrationForm.setDeliveryType(resultSet.getInt("DELIVERY_TYPE"));
        registrationForm.setCorrespondent(resultSet.getInt("CORRESPONDENT"));
        registrationForm.setTheme(resultSet.getString("THEME"));
        registrationForm.setDescription(resultSet.getString("DESCRIPTION"));
        registrationForm.setDueDate(resultSet.getDate("DUE_DATE"));
        registrationForm.setAccess(resultSet.getInt("ACCESS"));
        registrationForm.setControl(resultSet.getInt("CONTROL"));
        registrationForm.setFileName(resultSet.getString("FILE_NAME"));
        registrationForm.setFilePathName(resultSet.getString("FILE_REL_PATH"));

        return registrationForm;
    }
}
