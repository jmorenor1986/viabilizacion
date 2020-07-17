package co.com.santander.dto.mail;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MailPayload {

    private String emailTO;
    private String decision;
    private String emailCC;
    private String emailBcc;
    private CustomerPayload customer;
    private String urlAction;
    private String numberRequest;
}
