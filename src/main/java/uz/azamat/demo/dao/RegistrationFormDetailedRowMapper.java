package uz.azamat.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import uz.azamat.demo.model.IncomingDocumentsUI;

public class RegistrationFormDetailedRowMapper implements RowMapper<IncomingDocumentsUI> {

    @Override
    public IncomingDocumentsUI mapRow(final ResultSet resultSet, final int i) throws SQLException {
        IncomingDocumentsUI registrationForm = new IncomingDocumentsUI();
        registrationForm.setId(resultSet.getInt("ID"));
        registrationForm.setRegisterNumber(resultSet.getString("REGISTER_NUM"));
        registrationForm.setRegisterDate(resultSet.getDate("REGISTER_DATE"));
        registrationForm.setOutgoingNumber(resultSet.getString("OUTGOING_NUM"));
        registrationForm.setOutgoingDate(resultSet.getDate("OUTGOING_DATE"));
        registrationForm.setDeliveryType(resultSet.getInt("DELIVERY_TYPE"));
        registrationForm.setDeliveryTypeName(resultSet.getString("DELIVERY_TYPE_NAME"));
        registrationForm.setCorrespondent(resultSet.getInt("CORRESPONDENT"));
        registrationForm.setCorrespondentName(resultSet.getString("CORRESPONDENT_NAME"));
        registrationForm.setTheme(resultSet.getString("THEME"));
        registrationForm.setDescription(resultSet.getString("DESCRIPTION"));
        registrationForm.setDueDate(resultSet.getDate("DUE_DATE"));
        int access = resultSet.getInt("ACCESS");
        registrationForm.setAccess(access);
        registrationForm.setAccessName(access == 0 ? "Нет" : "Да");
        int control = resultSet.getInt("CONTROL");
        registrationForm.setControl(control);
        registrationForm.setControlName(control == 0 ? "Нет" : "Да");
        registrationForm.setFileName(resultSet.getString("FILE_NAME"));
        registrationForm.setFilePathName(resultSet.getString("FILE_REL_PATH"));

        return registrationForm;
    }
}
