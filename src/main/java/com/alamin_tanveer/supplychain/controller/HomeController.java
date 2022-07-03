package com.alamin_tanveer.supplychain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/page/v1")
public class HomeController {
    @GetMapping("/home")
    public String page(){
        return "index";
    }
}
