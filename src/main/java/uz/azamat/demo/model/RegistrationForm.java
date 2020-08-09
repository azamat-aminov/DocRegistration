package uz.azamat.demo.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
@Data
public class RegistrationForm {
    private String registerNumber;
    private String registerDate;
    private String leaveRegisterNumber;
    private String leaveDate;
    private String formDelivery;
    private String correspondent;
    private String topic;
    private String description;
    private String executionPeriod;
    private Boolean access;
    private Boolean control;
    private String fileName;
    private String fileRelPath;
    private MultipartFile file;
}
