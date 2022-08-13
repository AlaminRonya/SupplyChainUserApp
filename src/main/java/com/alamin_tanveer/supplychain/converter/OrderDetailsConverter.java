package com.alamin_tanveer.supplychain.converter;

import com.alamin_tanveer.supplychain.dto.response.ResponseOrderDetails;
import com.alamin_tanveer.supplychain.entities.order_process.OrderDetails;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderDetailsConverter {

    public ResponseOrderDetails getOrderDetails(OrderDetails orderDetails){

        ResponseOrderDetails details = new ResponseOrderDetails();
        details.setId(orderDetails.getId());
        details.setUsername(orderDetails.getUsername());
        details.setQuantity(orderDetails.getQuantity());
        details.setTotal(orderDetails.getTotal());
        orderDetails.setCreatedAt(orderDetails.getCreatedAt());
        details.setModifiedAt(orderDetails.getModifiedAt());
        details.setUser(orderDetails.getUser());
        details.setPayment(orderDetails.getPayment());

        return details;
    }

    public List<ResponseOrderDetails> getAllPaymentDetails(List<OrderDetails> orderDetails){
        return orderDetails.stream().map(this::getOrderDetails).toList();
    }
}
