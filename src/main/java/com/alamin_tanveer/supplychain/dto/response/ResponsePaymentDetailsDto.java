package com.alamin_tanveer.supplychain.dto.response;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class ResponsePaymentDetailsDto {
    private Long id;
    private Double amount;
    private Double due;
    private Date createdAt;
    private Date modifiedAt;
    private String username;
    private String status;
}
