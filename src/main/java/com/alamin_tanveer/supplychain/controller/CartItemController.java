package com.alamin_tanveer.supplychain.controller;

import com.alamin_tanveer.supplychain.dto.response.ResponseProductDto;
import com.alamin_tanveer.supplychain.service.order_process.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page/v1/dealers/products")
public class CartItemController {
    @Autowired
    private CartItemService cartItemService;

    @GetMapping("/cartItem/{id}")
    public String cartItemShow(@PathVariable("id")String id, Model model){
        final ResponseProductDto productAddCardItem = cartItemService.getResponseProductById(Long.parseLong(id));
        model.addAttribute("responseProductDto", productAddCardItem);
        return "cart/addToCart";
    }

    @GetMapping("/addCart/{id}")
    public String addToCart(@PathVariable("id") String id){
        final Boolean aBoolean = cartItemService.addToCartItem(Long.parseLong(id),
                SecurityContextHolder.getContext().getAuthentication().getName());
        if (aBoolean){
            System.out.println("Inserted");
        }
        return "redirect:/page/v1/dealers/products/all";
    }
    @GetMapping("/cartItem/all")
    public String getAllCartItem(Model model){
        cartItemService.getAllCartItem();
        return "cart/cartItem";
    }
}
