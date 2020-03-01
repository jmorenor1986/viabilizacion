package co.com.santander.bizagi.dto;

import lombok.Data;

@Data
public class RequestCreateCaseDTO {
    private String domain;
    private String userName;
    private String process;
    private String documentNumber;
    private String typeDocument;
    private String buroScore;
}
