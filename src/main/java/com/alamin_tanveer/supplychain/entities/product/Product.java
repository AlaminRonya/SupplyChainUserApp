package com.alamin_tanveer.supplychain.entities.product;

import com.alamin_tanveer.supplychain.entities.Attachment;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "product")
public class Product {
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    @Setter(AccessLevel.NONE)
    private Long id;
    private String name;
    private String description;
    private String SKU;
    private Double price;
    private Date createdAt;
    private Date modifiedAt;
    private Date deletedAt;

    @ManyToOne(fetch = FetchType.LAZY) //, targetEntity = User.class)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private ProductCategory category;


    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "inventory_id", referencedColumnName = "id")
    private ProductInventory productInventory;


    @ManyToOne(fetch = FetchType.LAZY) //, targetEntity = User.class)
    @JoinColumn(name = "discount_id", referencedColumnName = "id")
    private Discount discount;



    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinTable(name = "products_attachments",
            joinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "attachment_id", referencedColumnName = "id")})
    private List<Attachment> photosAttachmentList;

}
