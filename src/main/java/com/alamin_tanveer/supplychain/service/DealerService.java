package com.alamin_tanveer.supplychain.service;

import com.alamin_tanveer.supplychain.appuser.AppUser;
import com.alamin_tanveer.supplychain.appuser.AppUserRepository;
import com.alamin_tanveer.supplychain.converter.DealerConverter;
import com.alamin_tanveer.supplychain.dto.request.DealerDto;
import com.alamin_tanveer.supplychain.entities.Attachment;
import com.alamin_tanveer.supplychain.entities.Dealer;
import com.alamin_tanveer.supplychain.registration.validator.AppDealerRegistrationValidator;
import com.alamin_tanveer.supplychain.registration.verification.AppDealerRegistrationVerification;
import com.alamin_tanveer.supplychain.repositories.DealerRepo;
import com.alamin_tanveer.supplychain.utils.Constant;
import com.alamin_tanveer.supplychain.utils.CurrentUser;
import com.alamin_tanveer.supplychain.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    @Autowired
    private AttachmentService attachmentService;


    public void addDealer(DealerDto dto, MultipartFile tinFile, MultipartFile photo) throws IOException {

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

        final Attachment tinAttachment = Utils.saveFile(tinFile, Constant.USER_UPLOAD_TRADE_LICENSE);
        final Attachment tinFilePdf = attachmentService.addAttachment(tinAttachment);
        final Attachment photoAttachment = Utils.saveImage(photo, Constant.USER_UPLOAD_PROFILE);
        final Attachment profilePhoto = attachmentService.addAttachment(photoAttachment);

        final AppUser appUser = appUserRepository.findByEmail(CurrentUser.getCurrentUserName()).orElse(null);

        if (appUser != null && tinFilePdf != null && profilePhoto != null){
            final Dealer dealer = dealerConverter.getDtoToPojo(dto);
            dealer.setUser(appUser);
            dealer.setTradeLicenseDocument(tinFilePdf);
            dealer.setProfilePhoto(profilePhoto);
            dealerRepo.save(dealer);
            System.out.println("insert dealer!");
        }else {
            System.out.println("Not insert dealer");
        }

    }
}
