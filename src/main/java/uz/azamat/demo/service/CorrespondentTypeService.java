package uz.azamat.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.azamat.demo.dao.CorrespondentTypeDao;
import uz.azamat.demo.model.CorrespondentType;

import java.util.List;
@Service
public class CorrespondentTypeService {
    @Autowired
    CorrespondentTypeDao correspondentTypeDao;

    public List<CorrespondentType> getAllCorrespondent(){
        return correspondentTypeDao.getAllCorrespondent();
    }
}
