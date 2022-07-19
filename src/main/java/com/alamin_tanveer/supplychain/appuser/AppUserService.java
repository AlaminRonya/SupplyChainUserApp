package com.alamin_tanveer.supplychain.appuser;

import com.alamin_tanveer.supplychain.email.EmailService;
import com.alamin_tanveer.supplychain.registration.token.ConfirmationToken;
import com.alamin_tanveer.supplychain.registration.token.ConfirmationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class AppUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG = "user with email %s not found";

    @Autowired
    private  AppUserRepository appUserRepository;

    @Autowired
    private  BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private ConfirmationTokenService confirmationTokenService;
    @Autowired
    private EmailService emailService;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));

    }

    public String signUpUser(AppUser appUser) {
        boolean userExists = appUserRepository.findByEmail(appUser.getEmail()).isPresent();

        if (userExists) {
            // TODO check of attributes are the same and
            // TODO if email not confirmed send confirmation email.

            throw new IllegalStateException("email already taken");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());

        appUser.setPassword(encodedPassword);

        appUserRepository.save(appUser);


        // TODO send to confirmation
        String token;
        while (true){
            token = UUID.randomUUID().toString();
            final boolean present = confirmationTokenService.getToken(token).isPresent();
            if (!present){
                ConfirmationToken confirmationToken = new ConfirmationToken(token, LocalDateTime.now(),
                        LocalDateTime.now().plusHours(48), appUser);
                confirmationTokenService.saveConfirmationToken(confirmationToken);
                break;
            }

        }

        // TODO send to email
//        emailService.send(appUser.getName(), appUser.getEmail());


        return token;
    }


}
