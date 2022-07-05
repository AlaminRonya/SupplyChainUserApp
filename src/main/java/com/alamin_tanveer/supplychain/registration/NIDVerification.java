package com.alamin_tanveer.supplychain.registration;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class NIDVerification implements Predicate<String> {
    @Override
    public boolean test(String s) {
//        TODO: third party api NID number and compare the registration NID number
        return true;
    }
}
