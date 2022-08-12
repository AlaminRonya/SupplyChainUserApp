package com.alamin_tanveer.supplychain.dto.request;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class OrderCartItemDto {
    private Long cartId;
    private String productName;
    private Integer qty;
}
