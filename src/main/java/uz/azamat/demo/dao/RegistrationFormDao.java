package uz.azamat.demo.dao;

import uz.azamat.demo.model.IncomingDocuments;

import java.util.List;

public interface RegistrationFormDao {
    List<IncomingDocuments> getAllData();
    List<IncomingDocuments> getAllFromCentralBankViaEmailForCurrentMonth();
    List<IncomingDocuments> getAllForFirstQuarterOfThisYearExceptFromGniViaCurrier();

    IncomingDocuments getById(int id);

    void save(IncomingDocuments incomingDocuments);
}
