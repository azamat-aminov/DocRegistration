package uz.azamat.demo.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uz.azamat.demo.model.IncomingDocuments;

import java.util.List;
import uz.azamat.demo.model.IncomingDocumentsUI;

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
                "AND DELIVERY_TYPE=(SELECT ID FROM ref_data WHERE NAME ='Email' AND REF_TYPE_ID = (SELECT ID FROM ref_types WHERE NAME='delivery_type')) ";
        return jdbcTemplate.query(query, new RegistrationFormRowMapper());
    }

    @Override
    public List<IncomingDocuments> getAllForFirstQuarterOfThisYearExceptFromGniViaCurrier() {
        String query = "SELECT * FROM incoming_docs \n" +
                "WHERE (MONTH(REGISTER_DATE) < 4 AND YEAR(REGISTER_DATE) = YEAR(CURDATE())) \n" +
                "AND NOT (CORRESPONDENT = (SELECT ID FROM ref_data WHERE NAME ='ГНИ' AND REF_TYPE_ID=(SELECT ID FROM ref_types WHERE NAME='correspondent_type')) \n" +
                "\t\tAND DELIVERY_TYPE = (SELECT ID FROM ref_data WHERE NAME ='Курьер' AND REF_TYPE_ID=(SELECT ID FROM ref_types WHERE NAME='delivery_type'))) ";
        return jdbcTemplate.query(query, new RegistrationFormRowMapper());
    }

    @Override
    public List<IncomingDocuments> getAllFromTsjInCurrentMonthExceptCredits() {
        String query = "SELECT * FROM incoming_docs \n" +
                "WHERE MONTH(REGISTER_DATE) = (MONTH(CURDATE()) - 1) AND YEAR(REGISTER_DATE) = YEAR(CURDATE())\n" +
                "\tAND CORRESPONDENT = (SELECT ID FROM ref_data WHERE NAME ='ТСЖ' AND REF_TYPE_ID=(SELECT ID FROM ref_types WHERE NAME='correspondent_type') ) \n" +
                "\tAND LOWER(THEME) NOT LIKE '%кредит%'\n" +
                "\tAND LOWER(THEME) NOT LIKE '%kredit%'\n" +
                "\tAND LOWER(THEME) NOT LIKE '%credit%';  ";
        return jdbcTemplate.query(query, new RegistrationFormRowMapper());
    }

    @Override
    public IncomingDocumentsUI getById(int id) {
        String query = "SELECT ind.*, \n" +
                "(select name from ref_data rd  where rd.ID = ind.DELIVERY_TYPE) as DELIVERY_TYPE_NAME,\n" +
                "(select name from ref_data rd  where rd.ID = ind.CORRESPONDENT) as CORRESPONDENT_NAME\n" +
                "FROM incoming_docs ind WHERE ind.ID = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{id}, new RegistrationFormDetailedRowMapper());
    }

    @Override
    public IncomingDocuments getByRegNum(final String registerNumber) {
        String query = "SELECT * FROM incoming_docs where REGISTER_NUM=?";
        return jdbcTemplate.queryForObject(query, new Object[]{registerNumber}, new RegistrationFormRowMapper());
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
