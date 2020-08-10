package uz.azamat.demo.dao;

import uz.azamat.demo.model.IncomingDocuments;
import uz.azamat.demo.model.RegistrationForm;

import java.util.List;

public interface RegistrationFormDao {
    List<RegistrationForm> getAllData();

    void save(IncomingDocuments incomingDocuments);
}