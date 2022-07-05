package com.alamin_tanveer.supplychain.registration;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class BankAccountVerification implements Predicate<String> {
    @Override
    public boolean test(String s) {
//        TODO: third party api bank account number and compare the registration bank account number
        return true;
    }
}
