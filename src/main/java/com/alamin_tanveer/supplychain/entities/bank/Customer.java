package com.alamin_tanveer.supplychain.entities.bank;

import com.alamin_tanveer.supplychain.entities.bank.account.Bank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "customer")
public class Customer {
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )
    @Setter(AccessLevel.NONE)
    private Long id;
    private String customerName;
    private String accountNumber;
    private Date createdAt;
    private Date modifiedAt;
    private Date deletedAt;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Bank> banks;


}
