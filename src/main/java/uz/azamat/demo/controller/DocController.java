package uz.azamat.demo.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uz.azamat.demo.model.IncomingDocuments;
import uz.azamat.demo.service.CorrespondentTypeService;
import uz.azamat.demo.service.DeliveryService;
import uz.azamat.demo.service.RegistrationFormService;
import uz.azamat.demo.model.CorrespondentType;
import uz.azamat.demo.model.DeliveryType;
import uz.azamat.demo.model.RegistrationForm;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
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
    public String someMethod(RegistrationForm registrationForm, Model model) throws IOException {
        registrationFormService.saveAllData(registrationForm);
        model.addAttribute("allData", registrationFormService.getAllData());
        return "table";
    }

    @GetMapping("/getAllDocs")
    public String getAllDocs(Model model) {
        model.addAttribute("allData", registrationFormService.getAllData());
        return "table";
    }

    @GetMapping("/data/by/{id}")
    public String getOneDocById(Model model, @PathVariable int id) {
        IncomingDocuments byId = registrationFormService.getById(id);
        model.addAttribute("object", byId);
        return "moreInfoTable";
    }

    @GetMapping("/getFile/{id}")
    public String getFile(@PathVariable int id, HttpServletResponse response) throws IOException {
        IncomingDocuments docs = registrationFormService.getById(id);
        File fileToSend = new File("/home/azamat/docs/" + docs.getFilePathName());

        response.setHeader("Content-Disposition", "attachment; filename=" + docs.getFileName());
        InputStream in = new FileInputStream(fileToSend);
        IOUtils.copy(in, response.getOutputStream());
        response.flushBuffer();

        return "moreInfoTable";
    }
}
