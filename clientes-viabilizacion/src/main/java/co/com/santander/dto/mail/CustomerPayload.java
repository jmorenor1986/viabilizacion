package co.com.santander.dto.mail;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerPayload {

    private String firstName;
    private String lastName;

}
