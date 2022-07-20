package com.alamin_tanveer.supplychain.repositories.bank;

import com.alamin_tanveer.supplychain.entities.bank.account.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface BankRepo extends JpaRepository<Bank, Long> {
}
