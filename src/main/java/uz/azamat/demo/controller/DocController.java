package uz.azamat.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import uz.azamat.demo.model.IncomingDocuments;
import uz.azamat.demo.service.CorrespondentTypeService;
import uz.azamat.demo.service.DeliveryService;
import uz.azamat.demo.service.RegistrationFormService;
import uz.azamat.demo.model.CorrespondentType;
import uz.azamat.demo.model.DeliveryType;
import uz.azamat.demo.model.RegistrationForm;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Controller
public class DocController {
    @Resource
    DeliveryService deliveryService;
    @Resource
    CorrespondentTypeService correspondentTypeService;
    @Resource
    RegistrationFormService registrationFormService;

    @GetMapping()
    public String display() {
        return "welcome";
    }

    @GetMapping("/main")
    public String mainPage(Model model) {
        List<DeliveryType> allDelivery = deliveryService.getAllDelivery();
        model.addAttribute("forms", allDelivery);

        List<CorrespondentType> allCorrespondent = correspondentTypeService.getAllCorrespondent();
        model.addAttribute("correspondents", allCorrespondent);
        return "main";
    }

    @PostMapping("/saveDocs")
    public String someMethod(RegistrationForm registrationForm) throws IOException {
        registrationFormService.saveAllData(registrationForm);
        return "main";
    }

    @GetMapping("/getAllDocs")
    public String getAllDocs() {
        List<IncomingDocuments> allData = registrationFormService.getAllData();
        for (IncomingDocuments in : allData){
            System.out.println(in);
        }
        return "main";
    }
}
