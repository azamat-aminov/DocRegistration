package uz.azamat.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import uz.azamat.demo.model.IncomingDocumentsUI;

public class RegistrationFormDetailedRsExtractor implements ResultSetExtractor<IncomingDocumentsUI> {

    @Override
    public IncomingDocumentsUI extractData(final ResultSet rs) throws SQLException, DataAccessException {
        if (rs.next()) {
            IncomingDocumentsUI registrationForm = new IncomingDocumentsUI();
            registrationForm.setId(rs.getInt("ID"));
            registrationForm.setRegisterNumber(rs.getString("REGISTER_NUM"));
            registrationForm.setRegisterDate(rs.getDate("REGISTER_DATE"));
            registrationForm.setOutgoingNumber(rs.getString("OUTGOING_NUM"));
            registrationForm.setOutgoingDate(rs.getDate("OUTGOING_DATE"));
            registrationForm.setDeliveryType(rs.getInt("DELIVERY_TYPE"));
            registrationForm.setDeliveryTypeName(rs.getString("DELIVERY_TYPE_NAME"));
            registrationForm.setCorrespondent(rs.getInt("CORRESPONDENT"));
            registrationForm.setCorrespondentName(rs.getString("CORRESPONDENT_NAME"));
            registrationForm.setTheme(rs.getString("THEME"));
            registrationForm.setDescription(rs.getString("DESCRIPTION"));
            registrationForm.setDueDate(rs.getDate("DUE_DATE"));
            int access = rs.getInt("ACCESS");
            registrationForm.setAccess(access);
            registrationForm.setAccessName(access == 0 ? "Нет" : "Да");
            int control = rs.getInt("CONTROL");
            registrationForm.setControl(control);
            registrationForm.setControlName(control == 0 ? "Нет" : "Да");
            registrationForm.setFileName(rs.getString("FILE_NAME"));
            registrationForm.setFilePathName(rs.getString("FILE_REL_PATH"));

            return registrationForm;
        }
        return null;
    }
}
