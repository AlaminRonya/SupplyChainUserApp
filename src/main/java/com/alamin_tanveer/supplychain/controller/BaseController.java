package com.alamin_tanveer.supplychain.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/page/v1/user")
public class BaseController {
//    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

    @GetMapping("/home")
    public String page(){
//        System.out.println(request.getHeaderNames());
        return "home";
    }

    @GetMapping("/addDealer")
    public String dealerForm(){
        return "dealers/dealerRegistration";
    }


    @GetMapping("/username")
    public String getCurrentUserName(){
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
