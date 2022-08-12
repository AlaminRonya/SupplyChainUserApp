package com.alamin_tanveer.supplychain.service.bank;

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
        final Bank bank = getBank(accountNumber);
        if (bank == null){
            return false;
        }
        final Double balance = bank.getAccount().getBalance();
        if ( balance <= amount){
            return false;
        }
        double updateBalance = balance - amount;
        updateBalance(accountNumber, updateBalance);

        return true;
    }

    private Bank getBank(String number){
        final Bank bank = bankRepo.findUserByAccount(number).orElse(null);
        if (bank == null){
            System.out.println("Incorrect Account number");
            return null;
        }
        return bank;
    }
    private void updateBalance(String number, Double amount){
        accountRepo.update(number, amount);
    }


}
