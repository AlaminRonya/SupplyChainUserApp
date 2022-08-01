package com.alamin_tanveer.supplychain.controller;

import com.alamin_tanveer.supplychain.appuser.AppUserService;
import com.alamin_tanveer.supplychain.entities.product.ProductCategory;
import com.alamin_tanveer.supplychain.service.product.ProductCategoryService;
import com.alamin_tanveer.supplychain.service.product.ProductService;
import com.alamin_tanveer.supplychain.utils.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/page/v1/user/nav_bar_dealer")
public class UserNavBarController {
    @Autowired
    private AppUserService appUserService;
    @Autowired
    private ProductCategoryService productCategoryService;
    @Autowired
    private ProductService productService;

    @GetMapping("/dealer")
    public String dealerHome(Model model){
        final String userRole = appUserService.getUserRole(CurrentUser.getCurrentUserName());
        if (userRole.equals("DEALER_USER")){
            productCategoryService.getAllCategory().forEach(System.out::println);
            model.addAttribute("responseCategoriesDto", productCategoryService.getAllCategory());
            model.addAttribute("responseProductsDto", productService.getAllProduct());
            return "dealer/dealerHome";
        }
        return "redirect:/page/v1/user/home";
    }

    @GetMapping("/accountManager")
    public String accountManagerHome(){
        final String userRole = appUserService.getUserRole(CurrentUser.getCurrentUserName());
        if (userRole.equals("ACCOUNT_MANAGER")){
            return "account_manager/accountManagerHome";
        }
        return "redirect:/page/v1/user/home";
    }

    @GetMapping("/delivery")
    public String deliveryHome(){
        final String userRole = appUserService.getUserRole(CurrentUser.getCurrentUserName());
        if (userRole.equals("DELIVERY_IN_CHARGE")){
            return "delivery/deliveryHome";
        }
        return "redirect:/page/v1/user/home";
    }

}
