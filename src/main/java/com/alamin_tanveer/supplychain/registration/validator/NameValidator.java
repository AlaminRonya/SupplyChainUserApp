package com.alamin_tanveer.supplychain.registration.validator;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameValidator implements Predicate<String> {
//    https://www.geeksforgeeks.org/how-to-validate-a-username-using-regular-expressions-in-java/
    private final Pattern VALID_NAME_REGEX = Pattern.compile("^[A-Za-z]\\w{5,29}$");

    @Override
    public boolean test(String s) {
//        TODO: Regex to validate name
        Matcher matcher = VALID_NAME_REGEX.matcher(s);
        return matcher.find();
    }
}
