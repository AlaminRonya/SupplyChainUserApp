package com.alamin_tanveer.supplychain.service.bank;

import com.alamin_tanveer.supplychain.entities.bank.account.Account;
import com.alamin_tanveer.supplychain.entities.bank.account.Bank;
import com.alamin_tanveer.supplychain.repositories.bank.AccountRepo;
import com.alamin_tanveer.supplychain.repositories.bank.BankRepo;
import com.alamin_tanveer.supplychain.repositories.bank.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService {
    @Autowired
    private AccountRepo accountRepo;
    @Autowired
    private BankRepo bankRepo;
    @Autowired
    private CustomerRepo customerRepo;

    public Boolean withdraw(String accountNumber, Double amount){
        final Account account = getBank(accountNumber);
        if (account == null){
            return false;
        }
        final Double balance = account.getBalance();
        if ( balance <= amount){
            return false;
        }
        double updateBalance = balance - amount;
        updateBalance(accountNumber, updateBalance);

        return true;
    }

    private Account getBank(String number){
//        final Bank bank = bankRepo.findUserByAccount(number).orElse(null);
        final Account account = accountRepo.findByAccountNumber(number).orElse(null);
        if (account == null){
            System.out.println("Incorrect Account number");
            return null;
        }
        return account;
    }
    private void updateBalance(String number, Double amount){
        accountRepo.update(number, amount);
    }


}
