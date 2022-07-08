package com.alamin_tanveer.supplychain.registration.validator;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator implements Predicate<String> {

//    https://java2blog.com/validate-password-java/
    private final Pattern VALID_PASSWORD_REGEX = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$");

    @Override
    public boolean test(String s) {
//        TODO: Regex to validate password
        Matcher matcher = VALID_PASSWORD_REGEX.matcher(s);
        return matcher.find();
    }
}
