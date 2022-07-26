package com.alamin_tanveer.supplychain.entities.order_process;

import com.alamin_tanveer.supplychain.entities.product.Product;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "cart_item")
public class CartItem {
    @SequenceGenerator(
            name = "cart_item_sequence",
            sequenceName = "cart_item_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cart_item_sequence"
    )
    @Setter(AccessLevel.NONE)
    private Long id;
    private String username;
    private Long quantity= 0L;
    private Date createdAt;
    private Date modifiedAt;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

}
