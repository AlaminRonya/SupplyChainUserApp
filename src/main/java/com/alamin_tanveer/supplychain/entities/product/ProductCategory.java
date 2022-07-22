package com.alamin_tanveer.supplychain.entities.product;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@Table(name = "product_category")
public class ProductCategory {
    @SequenceGenerator(
            name = "category_sequence",
            sequenceName = "category_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "category_sequence"
    )
    @Setter(AccessLevel.NONE)
    private Long id;
    private String name;
    private String description;
    private Date createdAt;
    private Date modifiedAt;
    private Date deletedAt;
    private Boolean active = true;



}
