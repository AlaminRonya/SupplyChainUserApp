package com.alamin_tanveer.supplychain.entities.order_proccess;

import com.alamin_tanveer.supplychain.entities.product.Product;
import com.alamin_tanveer.supplychain.entities.product.ProductCategory;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "order_item")
public class OrderItem {

    @SequenceGenerator(
            name = "order_item_sequence",
            sequenceName = "order_item_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_item_sequence"
    )
    @Setter(AccessLevel.NONE)
    private Long id;
    private Long quantity;
    private Date createdAt;
    private Date modifiedAt;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private OrderDetails orderDetails;
}
