package com.alamin_tanveer.supplychain.repositories;

import com.alamin_tanveer.supplychain.appuser.AppUser;
import com.alamin_tanveer.supplychain.entities.Dealer;
import com.alamin_tanveer.supplychain.entities.order_process.PaymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface DealerRepo  extends JpaRepository<Dealer, Long> {
    Optional<Dealer> findByTradeLicenseNumber(String tinNumber);

//    @Transactional
//    @Modifying
//    @Query("SELECT d FROM Dealer d WHERE d.user = ?1 ")
    Optional<Dealer> getDealerByUsername(String username);
}
