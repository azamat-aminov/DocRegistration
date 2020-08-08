package uz.azamat.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import uz.azamat.demo.model.RegistrationForm;

@Controller
public class DocController {
    @GetMapping()
    public String display() {
        return "welcome";
    }

    @GetMapping("/main")
    public String mainPage() {
        return "main";
    }

    @PostMapping("/someUrl")
    public String someMethod(RegistrationForm registrationForm) {
        System.out.println(registrationForm.getRegisterNumber());
        return "main";
    }
}
