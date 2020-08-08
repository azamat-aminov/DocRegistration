package uz.azamat.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import uz.azamat.demo.model.CorrespondentType;
import uz.azamat.demo.model.DeliveryType;
import uz.azamat.demo.model.RegistrationForm;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DocController {
    @GetMapping()
    public String display() {
        return "welcome";
    }

    @GetMapping("/main")
    public String mainPage(Model model) {
        List<DeliveryType> deliveryTypes = new ArrayList<>();
        deliveryTypes.add(new DeliveryType(1, "Курьер"));
        deliveryTypes.add(new DeliveryType(2, "Email"));
        deliveryTypes.add(new DeliveryType(3, "Телефонограмма"));
        model.addAttribute("forms", deliveryTypes);

        List<CorrespondentType> correspondentTypes = new ArrayList<>();
        correspondentTypes.add(new CorrespondentType(1, "ЦБ"));
        correspondentTypes.add(new CorrespondentType(2, "ГНИ"));
        correspondentTypes.add(new CorrespondentType(3, "ТСЖ"));
        model.addAttribute("correspondents", correspondentTypes);

        return "main";
    }

    @PostMapping("/someUrl")
    public String someMethod(RegistrationForm registrationForm) {
        System.out.println(registrationForm.getRegisterNumber());
        return "main";
    }
}
