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
    private String phoneNumber;
    private LocalDate dob;
    private final String userNID;
    private final String userBankAccountNumber;
    private final String tradeLicenseNumber;
    private final String email;
    private final String password;

    private final String gender;
}
