package com.alamin_tanveer.supplychain.repositories.bank;

import com.alamin_tanveer.supplychain.entities.bank.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface CustomerRepo extends JpaRepository<Customer, Long> {

    Optional<Customer> findByAccountNumber(String accountNumber);

}
