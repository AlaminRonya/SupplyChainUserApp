package com.alamin_tanveer.supplychain.dto.request;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@ToString
public class CheckoutDto {
    @NotBlank(message = "*must not be blank")
    @Size(min = 1, max = 50, message = "*size must be between 1 and 50")
    private String username;
    @NotBlank(message = "*must not be blank")
    @Size(min = 1, max = 50, message = "*size must be between 1 and 50")
    private String accountNumber;
    @NotBlank(message = "*must not be blank")
    @Size(min = 1, max = 50, message = "*size must be between 1 and 50")
    private String firstName;
    @NotBlank(message = "*must not be blank")
    @Size(min = 1, max = 50, message = "*size must be between 1 and 50")
    private String lastName;
    @NotBlank(message = "*must not be blank")
    @Size(min = 1, max = 50, message = "*size must be between 1 and 50")
    private String address;
    @NotBlank(message = "*must not be blank")
    @Size(min = 1, max = 15, message = "*size must be between 1 and 15")
    private String postCodeOrZip;
    @NotBlank(message = "*must not be blank")
    @Size(min = 1, max = 50, message = "*size must be between 1 and 50")
    private String townOrCity;
    @NotBlank(message = "*must not be blank")
    @Size(min = 1, max = 50, message = "*size must be between 1 and 50")
    private String phoneNumber;
    @NotBlank(message = "*must not be blank")
    @Size(min = 1, max = 50, message = "*size must be between 1 and 50")
    private String additionalInfo;

    @NotNull(message = "*must not be blank")
    @Min(value = 0, message = "*The value must be positive")
    private Double amount;
}
