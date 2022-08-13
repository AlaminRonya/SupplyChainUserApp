package com.alamin_tanveer.supplychain.converter;

import com.alamin_tanveer.supplychain.dto.request.CheckoutDto;
import com.alamin_tanveer.supplychain.entities.order_process.Checkout;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Component
public class CheckoutConverter {
    private final LocalDate localDate = LocalDate.now();

    public Checkout getCheckout(CheckoutDto dto){

        Checkout checkout = new Checkout();
        checkout.setUsername(dto.getUsername());
        checkout.setAccountNumber(dto.getAccountNumber());
        checkout.setFirstName(dto.getFirstName());
        checkout.setLastName(dto.getLastName());
        checkout.setAddress(dto.getAddress());
        checkout.setPostCodeOrZip(dto.getPostCodeOrZip());
        checkout.setTownOrCity(dto.getTownOrCity());
        checkout.setPhoneNumber(dto.getPhoneNumber());
        checkout.setAdditionalInfo(dto.getAdditionalInfo());
        checkout.setAmount(dto.getAmount());
        checkout.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));

        return checkout;
    }
}
