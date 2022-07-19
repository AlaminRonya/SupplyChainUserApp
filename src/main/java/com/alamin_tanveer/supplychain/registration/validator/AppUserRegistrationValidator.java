package com.alamin_tanveer.supplychain.registration.validator;

import com.alamin_tanveer.supplychain.registration.RegistrationRequest;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public interface AppUserRegistrationValidator extends Function<RegistrationRequest, AppUserRegistrationValidator.ValidationResult> {

    static AppUserRegistrationValidator isName(){
        return request -> new NameValidator().test(request.getUserName())  ? ValidationResult.SUCCESS : ValidationResult.NAME_NOT_VALID;
    }
    static AppUserRegistrationValidator isEmail(){
        return request -> new EmailValidator().test(request.getEmail()) ? ValidationResult.SUCCESS : ValidationResult.EMAIL_NOT_VALID;
    }
    static AppUserRegistrationValidator isPasswordValid(){
        return request -> new PasswordValidator().test(request.getPassword())? ValidationResult.SUCCESS : ValidationResult.PASSWORD_NOT_VALID;
    }

//    static AppUserRegistrationValidator isPhoneNumberValid(){
//        return request -> new PhoneNumberValidator().test(request.getPhoneNumber()) ? ValidationResult.SUCCESS : ValidationResult.PHONE_NUMBER_NOT_VALID;
//    }
//    static AppUserRegistrationValidator isAdultValid(){
//        return request -> Period.between(request.getDob(), LocalDate.now()).getYears()>17? ValidationResult.SUCCESS : ValidationResult.IS_NOT_AN_ADULT;
//    }
//
//
//    static AppUserRegistrationValidator isNIDValid(){
//        return request -> new NIDValidator().test(request.getUserNID())? ValidationResult.SUCCESS : ValidationResult.NID_NOT_VALID;
//    }
//
//    static AppUserRegistrationValidator isAccountNumberValid(){
//        return request -> new BankAccountNumberValidator().test(request.getUserBankAccountNumber())? ValidationResult.SUCCESS : ValidationResult.NID_NOT_VALID;
//    }
//    static AppUserRegistrationValidator isTradeLicenseValid(){
//        return request -> new TradeLicenseValidator().test(request.getTradeLicenseNumber())? ValidationResult.SUCCESS : ValidationResult.NID_NOT_VALID;
//    }

    default AppUserRegistrationValidator and(AppUserRegistrationValidator other){
        return appUser -> {
            ValidationResult result = this.apply(appUser);
            return result.equals(ValidationResult.SUCCESS) ? other.apply(appUser) : result;
        };
    }
    enum ValidationResult{
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NOT_VALID,
        IS_NOT_AN_ADULT,
        NID_NOT_VALID,
        ACCOUNT_NUMBER_NOT_VALID,
        NAME_NOT_VALID,
        PASSWORD_NOT_VALID
    }
}


