package com.alamin_tanveer.supplychain.service;

import com.alamin_tanveer.supplychain.appuser.AppUser;
import com.alamin_tanveer.supplychain.appuser.AppUserRepository;
import com.alamin_tanveer.supplychain.converter.DealerConverter;
import com.alamin_tanveer.supplychain.dto.request.DealerDto;
import com.alamin_tanveer.supplychain.entities.Dealer;
import com.alamin_tanveer.supplychain.registration.validator.AppDealerRegistrationValidator;
import com.alamin_tanveer.supplychain.registration.verification.AppDealerRegistrationVerification;
import com.alamin_tanveer.supplychain.repositories.DealerRepo;
import com.alamin_tanveer.supplychain.utils.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Service
public class DealerService {
    @Autowired
    private DealerRepo dealerRepo;
    @Autowired
    private DealerConverter dealerConverter;
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private AppDealerRegistrationVerification appDealerRegistrationVerification;


    public void addDealer(DealerDto dto, MultipartFile tinFile, MultipartFile photo) {

        AppDealerRegistrationValidator.ValidationResult result = AppDealerRegistrationValidator.isPhoneNumberValid()
                .and(AppDealerRegistrationValidator.isAdultValid())
                .and(AppDealerRegistrationValidator.isAccountNumberValid())
                .and(AppDealerRegistrationValidator.isNIDValid())
                .and(AppDealerRegistrationValidator.isTradeLicenseValid())
                .apply(dto);
        if (result != AppDealerRegistrationValidator.ValidationResult.SUCCESS){
            throw new IllegalStateException(result.name());
        }

        final AppDealerRegistrationVerification.VerificationResult apply = appDealerRegistrationVerification.apply(dto);

        if (apply != AppDealerRegistrationVerification.VerificationResult.SUCCESS){
            throw new IllegalStateException(apply.name());
        }

        final boolean present = dealerRepo.findByTradeLicenseNumber(dto.getTradeLicenseNumber()).isPresent();
        if (present){
            throw new IllegalStateException("User is present!");
        }
        final AppUser appUser = appUserRepository.findByEmail(CurrentUser.getCurrentUserName()).orElse(null);
        if (appUser != null){
            final Dealer dealer = dealerConverter.getDtoToPojo(dto);
            dealer.setUser(appUser);
            dealerRepo.save(dealer);
            System.out.println("insert dealer!");
        }else {
            System.out.println("Not insert dealer");
        }

    }
}
