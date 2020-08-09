package uz.azamat.demo.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.azamat.demo.dao.DeliveryTypeDao;
import uz.azamat.demo.model.DeliveryType;

import java.util.List;
@Service
public class DeliveryService {
    @Autowired
    DeliveryTypeDao deliveryTypeDao;

    public List<DeliveryType> getAllDelivery(){
        return deliveryTypeDao.getAllDelivery();
    }
}
