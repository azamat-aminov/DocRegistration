package uz.azamat.demo.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.azamat.demo.dao.RegistrationFormDao;
import uz.azamat.demo.model.RegistrationForm;

@Service
public class RegistrationFormService {
    @Autowired
    RegistrationFormDao registrationFormDao;

    public void saveAllData(RegistrationForm registrationForm) {
        registrationFormDao.save(registrationForm);
    }
}
