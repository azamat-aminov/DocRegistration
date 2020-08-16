package uz.azamat.demo.model;

import lombok.Data;

@Data
public class IncomingDocumentsUI extends IncomingDocuments{
    private String accessName;
    private String controlName;
    private String deliveryTypeName;
    private String correspondentName;

}
