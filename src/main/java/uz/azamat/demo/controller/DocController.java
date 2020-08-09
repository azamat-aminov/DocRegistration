package uz.azamat.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import uz.azamat.demo.controller.service.CorrespondentTypeService;
import uz.azamat.demo.controller.service.DeliveryService;
import uz.azamat.demo.model.CorrespondentType;
import uz.azamat.demo.model.DeliveryType;
import uz.azamat.demo.model.RegistrationForm;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class DocController {
    @Resource
    DeliveryService deliveryService;
    @Resource
    CorrespondentTypeService correspondentTypeService;
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

    @PostMapping("/someUrl")
    public String someMethod(RegistrationForm registrationForm) {
        System.out.println(registrationForm.getRegisterNumber());
        return "main";
    }
}
