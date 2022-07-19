package com.alamin_tanveer.supplychain.registration;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private final String userName;
    private final String email;
    private final String password;
    private final String confirmedPassword;

}
