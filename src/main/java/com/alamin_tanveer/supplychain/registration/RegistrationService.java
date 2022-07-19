package com.alamin_tanveer.supplychain.registration;



import com.alamin_tanveer.supplychain.appuser.AppUser;
import com.alamin_tanveer.supplychain.appuser.AppUserRole;
import com.alamin_tanveer.supplychain.appuser.AppUserService;
import com.alamin_tanveer.supplychain.registration.validator.AppUserRegistrationValidator;
import com.alamin_tanveer.supplychain.registration.verification.BankAccountVerification;
import com.alamin_tanveer.supplychain.registration.validator.EmailValidator;
import com.alamin_tanveer.supplychain.registration.verification.NIDVerification;
import com.alamin_tanveer.supplychain.registration.verification.TradeLicenseVerification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    private AppUserService appUserService;




    public String register(RegistrationRequest request) {
//        boolean isValidEmail = emailValidator.test(request.getEmail());
//
//        if (!isValidEmail) {
//            throw new IllegalStateException("email not valid");
//        }

        AppUserRegistrationValidator.ValidationResult result = AppUserRegistrationValidator.isName()
                .and(AppUserRegistrationValidator.isEmail())
                .and(AppUserRegistrationValidator.isPasswordValid())
                .apply(request);

        if (result != AppUserRegistrationValidator.ValidationResult.SUCCESS){
            throw new IllegalStateException(result.name());
        }

        String token = appUserService.signUpUser(
                new AppUser(
                        request.getUserName(),
                        request.getEmail(),
                        request.getPassword(),
                        AppUserRole.USER
                )
        );
        return token;
    }

}
