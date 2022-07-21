package com.alamin_tanveer.supplychain.repositories;

import com.alamin_tanveer.supplychain.entities.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface DealerRepo  extends JpaRepository<Dealer, Long> {
    Optional<Dealer> findByTradeLicenseNumber(String tinNumber);
}
