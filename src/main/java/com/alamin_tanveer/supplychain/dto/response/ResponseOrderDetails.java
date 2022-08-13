package com.alamin_tanveer.supplychain.dto.response;

import com.alamin_tanveer.supplychain.appuser.AppUser;
import com.alamin_tanveer.supplychain.entities.order_process.PaymentDetails;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class ResponseOrderDetails {
    private Long id;
    private String username;
    private Long quantity;
    private Double total;
    private Date createdAt;
    private Date modifiedAt;
    private AppUser user;
    private PaymentDetails payment;
}
