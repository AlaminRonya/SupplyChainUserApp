package com.alamin_tanveer.supplychain.registration;

import java.util.function.Predicate;

public class BankAccount_Verification implements Predicate<String> {
    @Override
    public boolean test(String s) {
//        TODO: third party api bank account number and compare the registration bank account number number
        return true;
    }
}
