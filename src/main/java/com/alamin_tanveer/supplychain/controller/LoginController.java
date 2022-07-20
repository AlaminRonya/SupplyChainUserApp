package com.alamin_tanveer.supplychain.controller;

import com.alamin_tanveer.supplychain.entities.bank.Customer;
import com.alamin_tanveer.supplychain.service.bank.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class LoginController {

    @GetMapping("/login-process")
    public String getLoginPage(){

        return "auth/login";
    }



}
