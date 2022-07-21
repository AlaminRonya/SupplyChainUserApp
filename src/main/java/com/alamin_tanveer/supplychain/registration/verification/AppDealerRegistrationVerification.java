package com.alamin_tanveer.supplychain.registration.verification;

import com.alamin_tanveer.supplychain.dto.request.DealerDto;
import com.alamin_tanveer.supplychain.repositories.bank.CustomerRepo;
import com.alamin_tanveer.supplychain.repositories.third_party.NIDStorageRepo;
import com.alamin_tanveer.supplychain.repositories.third_party.TINStorageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class AppDealerRegistrationVerification implements Function<DealerDto, AppDealerRegistrationVerification.VerificationResult> {

    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private NIDStorageRepo nidStorageRepo;
    @Autowired
    private TINStorageRepo tinStorageRepo;


    private VerificationResult isAccountNumberVerification(String accountNumber){
        return  new BankAccountVerification(customerRepo).test(accountNumber) ? VerificationResult.SUCCESS : VerificationResult.ACCOUNT_NUMBER_NOT_VALID;
    }

    private VerificationResult isNIDVerification(String nid){
        return new NIDVerification(nidStorageRepo).test(nid)? VerificationResult.SUCCESS : VerificationResult.NID_NOT_VALID;
    }

    private VerificationResult isTINNumberVerification(String tin){
        return new TradeLicenseVerification(tinStorageRepo).test(tin)? VerificationResult.SUCCESS : VerificationResult.TIN_NOT_VALID;
    }

    @Override
    public VerificationResult apply(DealerDto dto) {
        return isVerify(dto);
    }

    private VerificationResult isVerify(DealerDto dto) {
        final VerificationResult accountNumberVerification = isAccountNumberVerification(dto.getUserBankAccountNumber());
        if ( accountNumberVerification != VerificationResult.SUCCESS){
            return accountNumberVerification;
        }
        final VerificationResult nidVerification = isNIDVerification(dto.getUserNID());
        if ( nidVerification != VerificationResult.SUCCESS){
            return nidVerification;
        }
        final VerificationResult tinNumberVerification = isTINNumberVerification(dto.getTradeLicenseNumber());
        if ( tinNumberVerification != VerificationResult.SUCCESS){
            return tinNumberVerification;
        }
        return VerificationResult.SUCCESS;

    }


//    default AppDealerRegistrationVerification and(AppDealerRegistrationVerification other){
//        return appUser -> {
//            VerificationResult result = this.apply(appUser);
//            return result.equals(VerificationResult.SUCCESS) ? other.apply(appUser) : result;
//        };
//    }



    public enum VerificationResult {
        SUCCESS,
        NID_NOT_VALID,
        TIN_NOT_VALID,
        ACCOUNT_NUMBER_NOT_VALID
    }
}


