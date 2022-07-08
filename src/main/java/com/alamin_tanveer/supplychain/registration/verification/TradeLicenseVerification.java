package com.alamin_tanveer.supplychain.registration.verification;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class TradeLicenseVerification implements Predicate<String> {
    @Override
    public boolean test(String s) {
//      TODO: third party api trade license number and compare the registration trade license number

        return true;
    }
}
