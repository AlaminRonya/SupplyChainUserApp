package com.alamin_tanveer.supplychain.registration.verification;

import com.alamin_tanveer.supplychain.repositories.bank.CustomerRepo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Component
public class BankAccountVerification implements Predicate<String> {
     private final CustomerRepo customerRepo;

    public BankAccountVerification(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }


    @Override
    public boolean test(String s) {
//        TODO: third party api bank account number and compare the registration bank account number
        return customerRepo.findByAccountNumber(s).isPresent();
    }
}
