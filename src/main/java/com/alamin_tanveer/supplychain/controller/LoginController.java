package com.alamin_tanveer.supplychain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login-process")
    public String getLoginPage(){
        return "auth/login";
    }



}
