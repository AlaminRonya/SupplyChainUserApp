package com.alamin_tanveer.supplychain.registration.validator;

import com.alamin_tanveer.supplychain.dto.request.DealerDto;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public interface AppDealerRegistrationValidator extends Function<DealerDto, AppDealerRegistrationValidator.ValidationResult> {



    static AppDealerRegistrationValidator isPhoneNumberValid(){
        return request -> new PhoneNumberValidator().test(request.getPhoneNumber()) ? ValidationResult.SUCCESS : ValidationResult.PHONE_NUMBER_NOT_VALID;
    }
    static AppDealerRegistrationValidator isAdultValid(){
        return request -> Period.between(request.getDob(), LocalDate.now()).getYears()>17? ValidationResult.SUCCESS : ValidationResult.IS_NOT_AN_ADULT;
    }


    static AppDealerRegistrationValidator isNIDValid(){
        return request -> new NIDValidator().test(request.getUserNID())? ValidationResult.SUCCESS : ValidationResult.NID_NOT_VALID;
    }

    static AppDealerRegistrationValidator isAccountNumberValid(){
        return request -> new BankAccountNumberValidator().test(request.getUserBankAccountNumber())? ValidationResult.SUCCESS : ValidationResult.ACCOUNT_NUMBER_NOT_VALID;
    }
    static AppDealerRegistrationValidator isTradeLicenseValid(){
        return request -> new TradeLicenseValidator().test(request.getTradeLicenseNumber())? ValidationResult.SUCCESS : ValidationResult.TIN_NOT_VALID;
    }

    default AppDealerRegistrationValidator and(AppDealerRegistrationValidator other){
        return appUser -> {
            ValidationResult result = this.apply(appUser);
            return result.equals(ValidationResult.SUCCESS) ? other.apply(appUser) : result;
        };
    }
    enum ValidationResult{
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        IS_NOT_AN_ADULT,
        NID_NOT_VALID,
        TIN_NOT_VALID,
        ACCOUNT_NUMBER_NOT_VALID
    }
}


