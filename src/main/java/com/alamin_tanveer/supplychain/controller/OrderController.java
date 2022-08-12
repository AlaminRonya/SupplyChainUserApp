package com.alamin_tanveer.supplychain.controller;

import com.alamin_tanveer.supplychain.dto.request.CheckoutDto;
import com.alamin_tanveer.supplychain.dto.response.ResponseCartItem;
import com.alamin_tanveer.supplychain.service.order_process.CartItemService;
import com.alamin_tanveer.supplychain.service.order_process.OrderService;
import com.alamin_tanveer.supplychain.utils.Constant;
import com.alamin_tanveer.supplychain.utils.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/page/v1/dealers/products")
public class OrderController {
    @Autowired
    private CartItemService cartItemService;
    @Autowired
    private OrderService orderService;

    @GetMapping("/view/order")
    public String getOrderPage(Model model){
        final List<ResponseCartItem> orderItems = cartItemService.getOrderItems();
        int lg = 0;
        if (orderItems != null){
            lg = orderItems.size();
            model.addAttribute("cartCount", orderItems.size());
            model.addAttribute("responseCartItemsDto", orderItems);
        }

        final double totalPrice = getTotalProductPrice();
        final double total = getTotalPriceAndOthers();

        model.addAttribute("username", username());
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("carton", cartItemService.getTotalCarton());
        model.addAttribute("shippingFee", Constant.SHIPPING_FEE);
        model.addAttribute("VAT", Constant.VAT);
        model.addAttribute("total", total);
        return "order_item/orderItemSubmitted";
    }
    @GetMapping("/remove/item/{id}")
    public String removedOrderItem(@PathVariable("id") String id){
        cartItemService.removeOrderItemById(Long.parseLong(id));
        return "redirect:/page/v1/dealers/products/view/order";
    }

    @GetMapping("/checkout")
    public String getCheckoutPage(Model model, @ModelAttribute("checkoutDto") CheckoutDto dto){


        final double totalPrice = getTotalProductPrice();
        final double total = getTotalPriceAndOthers();

        model.addAttribute("username", username());
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("carton", cartItemService.getTotalCarton());
        model.addAttribute("shippingFee", Constant.SHIPPING_FEE);
        model.addAttribute("VAT", Constant.VAT);
        model.addAttribute("total", total);
        return "order_item/checkout";
    }
    @PostMapping("/checkout")
    public String checkout(Model model, @Valid @ModelAttribute("checkoutDto") CheckoutDto dto, BindingResult result){
        System.out.println(dto);

        if (result.hasErrors()){
            final double totalPrice = getTotalProductPrice();
            final double total = getTotalPriceAndOthers();

            model.addAttribute("username", username());
            model.addAttribute("totalPrice", totalPrice);
            model.addAttribute("carton", cartItemService.getTotalCarton());
            model.addAttribute("shippingFee", Constant.SHIPPING_FEE);
            model.addAttribute("VAT", Constant.VAT);
            model.addAttribute("total", total);
            return "order_item/checkout";
        }
        if (username().equals(dto.getUsername())){
            orderService.orderDealer(dto);
        }

        return "redirect:/page/v1/dealers/products/cartItem/all";
    }
    private double getTotalProductPrice(){
        return cartItemService.getTotalPrice();
    }
    private double getTotalPriceAndOthers(){
        return getTotalProductPrice() + (getTotalProductPrice() * (Constant.VAT/100))+(cartItemService.getTotalCarton()*Constant.SHIPPING_FEE);
    }
    private String username(){
        return CurrentUser.getCurrentUserName();
    }
}
