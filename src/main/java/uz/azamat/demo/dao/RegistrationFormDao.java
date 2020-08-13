package uz.azamat.demo.dao;

import uz.azamat.demo.model.IncomingDocuments;
import uz.azamat.demo.model.RegistrationForm;

import java.util.List;

public interface RegistrationFormDao {
    List<IncomingDocuments> getAllData();

    IncomingDocuments getById(int id);

    void save(IncomingDocuments incomingDocuments);
}
