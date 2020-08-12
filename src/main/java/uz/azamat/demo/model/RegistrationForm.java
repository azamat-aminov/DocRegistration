package uz.azamat.demo.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
@Data
public class RegistrationForm {
    private int id;
    private String registerNumber;
    private String registerDate;
    private String leaveRegisterNumber;
    private String leaveDate;
    private String formDelivery;
    private String correspondent;
    private String description;
    private String executionPeriod;
    private String topic;
    private int access;
    private int control;
    private String fileName;
    private String fileRelPath;
    private MultipartFile file;
}
