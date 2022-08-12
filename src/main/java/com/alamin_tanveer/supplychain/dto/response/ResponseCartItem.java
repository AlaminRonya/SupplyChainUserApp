package com.alamin_tanveer.supplychain.dto.response;

import com.alamin_tanveer.supplychain.entities.product.Product;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@ToString
@Builder
public class ResponseCartItem {
    private Long id;
    private String username;
    private Integer quantity;
    private Date createdAt;
    private Date modifiedAt;
    private Product product;
}
