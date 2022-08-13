package com.alamin_tanveer.supplychain.controller;

import com.alamin_tanveer.supplychain.dto.response.ResponseProductDto;
import com.alamin_tanveer.supplychain.service.DealerService;
import com.alamin_tanveer.supplychain.service.order_process.OrderDetailsService;
import com.alamin_tanveer.supplychain.service.order_process.OrderService;
import com.alamin_tanveer.supplychain.service.order_process.PaymentDetailsService;
import com.alamin_tanveer.supplychain.service.product.ProductCategoryService;
import com.alamin_tanveer.supplychain.service.product.ProductService;
import com.alamin_tanveer.supplychain.utils.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/page/v1/dealer")
public class DealerController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductCategoryService productCategoryService;
    @Autowired
    private PaymentDetailsService paymentDetailsService;
    @Autowired
    private OrderDetailsService orderDetailsService;

    @GetMapping("/home")
    public String homePage(Model model){
        model.addAttribute("responseCategoriesDto", productCategoryService.getAllCategory());
        model.addAttribute("responseProductsDto", productService.getAllProduct());
        return "dealer/dealerHome";
    }

    @GetMapping("/category/search/{category_name}")
    public String searchCategory(@PathVariable("category_name") String categoryName, Model model){
        final List<ResponseProductDto> allProductByCategoryName = productService.getAllProductByCategoryName(categoryName);
        model.addAttribute("responseCategoriesDto", productCategoryService.getAllCategory());
        model.addAttribute("responseProductsDto", allProductByCategoryName);
        System.out.println(categoryName);
        return "dealer/dealerHome";
    }

    @GetMapping("/account")
    public String getAccountPage(Model model){
        model.addAttribute("paymentDetails", paymentDetailsService.getAllPaymentDetails(CurrentUser.getCurrentUserName()));
        return "account/paymentDetails";
    }

    @GetMapping("/order")
    public String getOrderPage(Model model){
        model.addAttribute("orderDetails", orderDetailsService.getAllOrderDetails(CurrentUser.getCurrentUserName()));
        return "orderDetails/orderDetails";
    }

}
