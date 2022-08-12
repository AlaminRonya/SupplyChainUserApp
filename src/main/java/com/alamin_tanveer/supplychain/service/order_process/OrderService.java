package com.alamin_tanveer.supplychain.service.order_process;

import com.alamin_tanveer.supplychain.appuser.AppUser;
import com.alamin_tanveer.supplychain.appuser.AppUserService;
import com.alamin_tanveer.supplychain.dto.request.CheckoutDto;
import com.alamin_tanveer.supplychain.dto.request.OrderCartItemDto;
import com.alamin_tanveer.supplychain.service.bank.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private CartItemService cartItemService;
    @Autowired
    private AppUserService appUserService;
    @Autowired
    private CheckoutService checkoutService;
    @Autowired
    private PaymentDetailsService paymentDetailsService;
    @Autowired
    private OrderDetailsService orderDetailsService;
    @Autowired
    private OrderItemService orderItemService;
    @Autowired
    private BankService bankService;


    public void orderDealer(CheckoutDto dto) {
        final Double totalPrice = cartItemService.getTotalPrice();
        if (dto.getAmount() < totalPrice/2){
            System.out.println("Not Order");
        }else {
            final List<OrderCartItemDto> allOrder = getAllOrder(dto.getUsername());
            final AppUser user = appUserService.getUser(dto.getUsername());
            if (allOrder != null && user != null){
                final Boolean withdraw = bankService.withdraw(dto.getAccountNumber(), dto.getAmount());


            }

        }


    }
    private List<OrderCartItemDto> getAllOrder(String username){
        return cartItemService.orderDealer(username);
    }
}
