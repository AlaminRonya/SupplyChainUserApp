package com.alamin_tanveer.supplychain.service.order_process;

import com.alamin_tanveer.supplychain.converter.CheckoutConverter;
import com.alamin_tanveer.supplychain.dto.request.CheckoutDto;
import com.alamin_tanveer.supplychain.entities.order_process.Checkout;
import com.alamin_tanveer.supplychain.repositories.order_process.CheckoutRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckoutService {
    @Autowired
    private CheckoutConverter checkoutConverter;

    @Autowired
    private CheckoutRepo checkoutRepo;


    public void addCheckout(CheckoutDto dto) {
        final Checkout checkout = checkoutConverter.getCheckout(dto);
        checkoutRepo.save(checkout);
    }
}
