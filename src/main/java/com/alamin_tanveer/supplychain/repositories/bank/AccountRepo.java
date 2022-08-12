package com.alamin_tanveer.supplychain.repositories.bank;

import com.alamin_tanveer.supplychain.entities.bank.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface AccountRepo extends JpaRepository<Account, Long> {

    Optional<Account> findByAccountNumber(String accNumber);

    @Transactional
    @Modifying
    @Query("UPDATE Account a " + "SET a.balance = ?2 WHERE a.accountNumber = ?1")
    int update(String accountNumber, Double balance);

}
