package com.alamin_tanveer.supplychain.registration;

import java.util.function.Predicate;

public class NID_Verification implements Predicate<String> {
    @Override
    public boolean test(String s) {
//        TODO: third party api NID number and compare the registration NID number
        return true;
    }
}
