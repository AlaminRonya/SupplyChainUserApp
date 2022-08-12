package com.alamin_tanveer.supplychain.entities.order_process;


import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "checkout")
public class Checkout {
    @SequenceGenerator(
            name = "checkout_sequence",
            sequenceName = "checkout_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "checkout_sequence"
    )
    @Setter(AccessLevel.NONE)
    private Long id;
    private String username;
    private String accountNumber;
    private String firstName;
    private String lastName;
    private String address;
    private String postCodeOrZip;
    private String townOrCity;
    private String phoneNumber;
    private String additionalInfo;
    private Double amount;
    private Date createdAt;
    private Date modifiedAt;
    private Boolean orderAccept = true;
    private Boolean delivery = true;
    private Boolean orderDone = true;
}
