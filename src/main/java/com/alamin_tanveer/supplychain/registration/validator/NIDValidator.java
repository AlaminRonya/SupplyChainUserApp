package com.alamin_tanveer.supplychain.registration.validator;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NIDValidator implements Predicate<String> {

    private final Pattern VALID_NID_NUMBER_REGEX = Pattern.compile("[0-9]+");

    @Override
    public boolean test(String s) {
//        TODO: Regex to validator NID number
        Matcher matcher = VALID_NID_NUMBER_REGEX.matcher(s);
        return matcher.find() && (matcher.group().length() == s.length()) && (s.length() == 10 || s.length() == 17) ;

    }
}
