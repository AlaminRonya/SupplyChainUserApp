package com.alamin_tanveer.supplychain.entities.order_process;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@Table(name = "payment_details")
public class PaymentDetails {
    @SequenceGenerator(
            name = "payment_details_sequence",
            sequenceName = "payment_details_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "payment_details_sequence"
    )
    @Setter(AccessLevel.NONE)
    private Long id;
}
