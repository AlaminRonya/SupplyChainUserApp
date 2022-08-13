package com.alamin_tanveer.supplychain.entities.bank.account;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "account")
public class Account {
    @SequenceGenerator(
            name = "account_sequence",
            sequenceName = "account_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "account_sequence"
    )
    @Setter(AccessLevel.NONE)
    private Long id;
    private String  accountNumber;
    protected Double balance = 12000.0;
    private Date createdAt;
    private Date modifiedAt;
    private Date deletedAt;

}
