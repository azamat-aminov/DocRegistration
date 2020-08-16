package uz.azamat.demo.dao;

import uz.azamat.demo.model.IncomingDocuments;

import java.util.List;
import uz.azamat.demo.model.IncomingDocumentsUI;

public interface RegistrationFormDao {
    List<IncomingDocuments> getAllData();
    List<IncomingDocuments> getAllFromCentralBankViaEmailForCurrentMonth();
    List<IncomingDocuments> getAllForFirstQuarterOfThisYearExceptFromGniViaCurrier();
    List<IncomingDocuments> getAllFromTsjInCurrentMonthExceptCredits();

    IncomingDocumentsUI getById(int id);
    IncomingDocuments getByRegNum(String registerNumber);

    void save(IncomingDocuments incomingDocuments);
}
