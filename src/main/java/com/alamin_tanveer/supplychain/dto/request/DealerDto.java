package com.alamin_tanveer.supplychain.dto.request;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString
public class DealerDto {
    private String username;
    private String phoneNumber;
    private LocalDate dob;
    private String userNID;
    private String userBankAccountNumber;
    private String tradeLicenseNumber;
    private String gender;
}
