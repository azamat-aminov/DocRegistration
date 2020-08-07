package uz.azamat.demo.model;

import java.io.File;

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
    private File file;

    public String getRegisterNumber() {
        return registerNumber;
    }

    public RegistrationForm setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
        return this;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public RegistrationForm setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
        return this;
    }

    public String getLeaveRegisterNumber() {
        return leaveRegisterNumber;
    }

    public RegistrationForm setLeaveRegisterNumber(String leaveRegisterNumber) {
        this.leaveRegisterNumber = leaveRegisterNumber;
        return this;
    }

    public String getLeaveDate() {
        return leaveDate;
    }

    public RegistrationForm setLeaveDate(String leaveDate) {
        this.leaveDate = leaveDate;
        return this;
    }

    public String getFormDelivery() {
        return formDelivery;
    }

    public RegistrationForm setFormDelivery(String formDelivery) {
        this.formDelivery = formDelivery;
        return this;
    }

    public String getCorrespondent() {
        return correspondent;
    }

    public RegistrationForm setCorrespondent(String correspondent) {
        this.correspondent = correspondent;
        return this;
    }

    public String getTopic() {
        return topic;
    }

    public RegistrationForm setTopic(String topic) {
        this.topic = topic;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RegistrationForm setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getExecutionPeriod() {
        return executionPeriod;
    }

    public RegistrationForm setExecutionPeriod(String executionPeriod) {
        this.executionPeriod = executionPeriod;
        return this;
    }

    public Boolean getAccess() {
        return access;
    }

    public RegistrationForm setAccess(Boolean access) {
        this.access = access;
        return this;
    }

    public Boolean getControl() {
        return control;
    }

    public RegistrationForm setControl(Boolean control) {
        this.control = control;
        return this;
    }

    public File getFile() {
        return file;
    }

    public RegistrationForm setFile(File file) {
        this.file = file;
        return this;
    }
}
