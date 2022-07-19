package com.alamin_tanveer.supplychain.controller;

import com.alamin_tanveer.supplychain.registration.RegistrationRequest;
import com.alamin_tanveer.supplychain.registration.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page/v1/registration")
public class RegistrationController {
//    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

    @Autowired
    private RegistrationService registrationService;



    @GetMapping("/add")
    public String getRegistration(@ModelAttribute("registrationRequest") RegistrationRequest registrationRequest){
        return "registration/registration";
    }

    @PostMapping("/add")
    public String userRegistration(@ModelAttribute("registrationRequest")RegistrationRequest registrationRequest){
        if (!registrationRequest.getPassword().equals(registrationRequest.getConfirmedPassword())) {
            return "redirect:/page/v1/registration/add";
        }
        registrationService.register(registrationRequest);


        return "redirect:/login-process";
    }
}
