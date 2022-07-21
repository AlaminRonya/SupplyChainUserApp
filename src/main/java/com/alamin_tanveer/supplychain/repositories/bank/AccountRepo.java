package com.alamin_tanveer.supplychain.repositories.bank;

import com.alamin_tanveer.supplychain.entities.bank.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface AccountRepo extends JpaRepository<Account, Long> {

}
