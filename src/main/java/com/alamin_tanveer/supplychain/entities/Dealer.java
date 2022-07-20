package com.alamin_tanveer.supplychain.entities;


import com.alamin_tanveer.supplychain.appuser.AppUser;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
@Data
@Entity
@Table(name = "dealer")
public class Dealer {
    @SequenceGenerator(
            name = "dealer_sequence",
            sequenceName = "dealer_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "dealer_sequence"
    )
    @Setter(AccessLevel.NONE)
    private Long id;
    private String phoneNumber;
    private LocalDate dob;
    private String userNID;
    private String userBankAccountNumber;
    private String tradeLicenseNumber;
    private String gender;
    private Boolean active = false;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private AppUser user;
}
