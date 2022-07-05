package com.alamin_tanveer.supplychain.registration;



import com.alamin_tanveer.supplychain.appuser.AppUser;
import com.alamin_tanveer.supplychain.appuser.AppUserRole;
import com.alamin_tanveer.supplychain.appuser.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    private AppUserService appUserService;
    @Autowired
    private  EmailValidator emailValidator;
    @Autowired
    private NIDVerification nidVerification;
    @Autowired
    private TradeLicenseVerification tradeLicenseVerification;
    @Autowired
    private BankAccountVerification bankAccountVerification;



    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());

        if (!isValidEmail) {
            throw new IllegalStateException("email not valid");
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
