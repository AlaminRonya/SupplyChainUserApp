package com.alamin_tanveer.supplychain.repositories.order_process;

import com.alamin_tanveer.supplychain.entities.order_process.PaymentDetails;
import com.alamin_tanveer.supplychain.enums.DealerPaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface PaymentDetailsRepo extends JpaRepository<PaymentDetails, Long> {

    Optional<List<PaymentDetails>> findPaymentDetailsByUsername(String username);

    @Transactional
    @Modifying
    @Query("SELECT P FROM PaymentDetails  P WHERE P.username = ?1 AND P.status = ?2")
    PaymentDetails getPaymentDetailsByStatusAndUsername(String username, String status);


}
