package com.alamin_tanveer.supplychain.registration;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private final String userName;
    private final String userNID;
    private final String tradeLicenseNumber;
    private final String gender;
    private final String email;
    private final String password;
}
