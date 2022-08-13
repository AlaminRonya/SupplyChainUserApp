package com.alamin_tanveer.supplychain.entities.order_process;

import com.alamin_tanveer.supplychain.enums.DealerPaymentStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "payment_details")
@ToString
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
    private Double amount;
    private Double due;
    private Date createdAt;
    private Date modifiedAt;
    private String username;
    @Enumerated(EnumType.STRING)
    private DealerPaymentStatus status;
}
