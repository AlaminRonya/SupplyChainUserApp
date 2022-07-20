package com.alamin_tanveer.supplychain.controller;

import com.alamin_tanveer.supplychain.dto.request.DealerDto;
import com.alamin_tanveer.supplychain.utils.CurrentUser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;


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
    public String dealerForm(Model model, @ModelAttribute("dealerDto") DealerDto dto){
        model.addAttribute("currentUserEmail", CurrentUser.getCurrentUserName());
        return "registration/dealerRegistration";
    }

    @PostMapping("/addDealer")
    public String dealerFormSubmitted(Model model, @ModelAttribute("dealerDto") DealerDto dto, @RequestParam("upload_file") MultipartFile tinFile, @RequestParam("profile_image") MultipartFile photo){
        dto.setUsername(CurrentUser.getCurrentUserName());
        System.out.println("=========>"+dto);
        model.addAttribute("currentUserEmail", CurrentUser.getCurrentUserName());
        return "redirect:/page/v1/user/addDealer";
    }


    @GetMapping("/username")
    public String getCurrentUserName(){
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
