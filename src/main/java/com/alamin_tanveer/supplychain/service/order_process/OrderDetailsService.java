package com.alamin_tanveer.supplychain.service.order_process;

import com.alamin_tanveer.supplychain.converter.OrderDetailsConverter;
import com.alamin_tanveer.supplychain.dto.response.ResponseOrderDetails;
import com.alamin_tanveer.supplychain.entities.order_process.OrderDetails;
import com.alamin_tanveer.supplychain.repositories.order_process.OrderDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsService {
    @Autowired
    private OrderDetailsRepo orderDetailsRepo;
    @Autowired
    private OrderDetailsConverter orderDetailsConverter;

    public OrderDetails addOrderDetails(OrderDetails orderDetails){
        return add(orderDetails);
    }

    public List<ResponseOrderDetails> getAllOrderDetails(String username){
        final List<OrderDetails> orderDetails = allOrderDetails(username);
        if (orderDetails != null){
            return orderDetailsConverter.getAllPaymentDetails(orderDetails);
        }
        return null;
    }

    private List<OrderDetails> allOrderDetails(String username){
        return orderDetailsRepo.findOrderDetailsByUsername(username).orElse(null);
    }
    private OrderDetails add(OrderDetails orderDetails){
        return orderDetailsRepo.save(orderDetails);
    }


}
