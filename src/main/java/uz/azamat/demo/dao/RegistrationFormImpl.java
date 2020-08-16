package uz.azamat.demo.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uz.azamat.demo.model.IncomingDocuments;

import java.util.List;

@Repository
public class RegistrationFormImpl implements RegistrationFormDao {
    JdbcTemplate jdbcTemplate;

    public RegistrationFormImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<IncomingDocuments> getAllData() {
        String query = "SELECT * FROM incoming_docs";
        return jdbcTemplate.query(query, new RegistrationFormRowMapper());
    }

    @Override
    public List<IncomingDocuments> getAllFromCentralBankViaEmailForCurrentMonth() {
        String query = "SELECT * FROM incoming_docs \n" +
                "WHERE (MONTH(REGISTER_DATE) = MONTH(CURDATE()) AND YEAR(REGISTER_DATE) = YEAR(CURDATE()))\n" +
                "AND CORRESPONDENT=(SELECT ID FROM ref_data WHERE NAME ='ЦБ' AND REF_TYPE_ID = (SELECT ID FROM ref_types WHERE NAME='correspondent_type')) \n" +
                "AND DELIVERY_TYPE=(SELECT ID FROM ref_data WHERE NAME ='Email' AND REF_TYPE_ID = (SELECT ID FROM ref_types WHERE NAME='delivery_type')); ";
        return jdbcTemplate.query(query, new RegistrationFormRowMapper());
    }

    @Override
    public IncomingDocuments getById(int id) {
        String query = "SELECT * FROM incoming_docs WHERE ID = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{id}, new RegistrationFormRowMapper());
    }

    @Override
    public void save(IncomingDocuments incomingDocuments) {
        String query = "INSERT INTO incoming_docs(REGISTER_NUM, REGISTER_DATE, OUTGOING_NUM, OUTGOING_DATE," +
                "DELIVERY_TYPE, CORRESPONDENT, THEME, DESCRIPTION, DUE_DATE, ACCESS, CONTROL, FILE_NAME, FILE_REL_PATH) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(query,
                incomingDocuments.getRegisterNumber(),
                incomingDocuments.getRegisterDate(),
                incomingDocuments.getOutgoingNumber(),
                incomingDocuments.getOutgoingDate(),
                incomingDocuments.getDeliveryType(),
                incomingDocuments.getCorrespondent(),
                incomingDocuments.getTheme(),
                incomingDocuments.getDescription(),
                incomingDocuments.getDueDate(),
                incomingDocuments.getAccess(),
                incomingDocuments.getControl(),
                incomingDocuments.getFileName(),
                incomingDocuments.getFilePathName());
    }
}
