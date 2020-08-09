package uz.azamat.demo.model;

import lombok.Data;

import java.sql.Date;
@Data
public class IncomingDocuments {
    private String registerNumber;
    private Date registerDate;
    private String outgoingNumber;
    private Date outgoingDate;
    private int deliveryType;
    private int correspondent;
    private String theme;
    private String description;
    private Date dueDate;
    private int access;
    private int control;
    private String fileName;
    private String filePathName;

}
