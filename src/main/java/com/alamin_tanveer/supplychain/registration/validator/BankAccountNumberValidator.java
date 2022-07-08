package com.alamin_tanveer.supplychain.registration.validator;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BankAccountNumberValidator implements Predicate<String> {

    private final Pattern VALID_BANK_ACCOUNT_NUMBER_REGEX = Pattern.compile("[0-9]+");

    @Override
    public boolean test(String s) {
//        TODO: Regex to validator Bank Account number
        Matcher matcher = VALID_BANK_ACCOUNT_NUMBER_REGEX.matcher(s);
        return matcher.find() && ((7 < s.length() && s.length() < 18) && (matcher.group().length() == s.length()));

    }
}
