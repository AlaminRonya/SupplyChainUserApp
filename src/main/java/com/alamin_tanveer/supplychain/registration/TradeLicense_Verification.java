package com.alamin_tanveer.supplychain.registration;

import java.util.function.Predicate;

public class TradeLicense_Verification implements Predicate<String> {
    @Override
    public boolean test(String s) {
//      TODO: third party api trade license number and compare the registration trade license number

        return true;
    }
}
