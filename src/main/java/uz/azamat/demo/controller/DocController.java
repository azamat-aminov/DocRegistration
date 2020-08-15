package uz.azamat.demo.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uz.azamat.demo.model.CorrespondentType;
import uz.azamat.demo.model.DeliveryType;
import uz.azamat.demo.model.IncomingDocuments;
import uz.azamat.demo.model.RegistrationForm;
import uz.azamat.demo.service.CorrespondentTypeService;
import uz.azamat.demo.service.DeliveryService;
import uz.azamat.demo.service.RegistrationFormService;

@Controller
public class DocController {

    @Autowired
    private DeliveryService deliveryService;
    @Autowired
    private CorrespondentTypeService correspondentTypeService;
    @Autowired
    private RegistrationFormService registrationFormService;
    @Value("${files.folder}")
    private String filesFolderPath;

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
    public ResponseEntity<Resource> getFile(@PathVariable int id, HttpServletResponse response) throws IOException {
        IncomingDocuments docs = registrationFormService.getById(id);
        File fileToSend = new File(filesFolderPath + docs.getFilePathName());

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + docs.getFileName() + "\"");

        Path path = Paths.get(fileToSend.getAbsolutePath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

        return ResponseEntity.ok()
                             .headers(headers)
                             .contentLength(fileToSend.length())
                             .contentType(MediaType.APPLICATION_OCTET_STREAM)
                             .body(resource);
    }
}
