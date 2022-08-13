package com.alamin_tanveer.supplychain.service.order_process;

import com.alamin_tanveer.supplychain.entities.order_process.OrderDetails;
import com.alamin_tanveer.supplychain.repositories.order_process.OrderDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailsService {
    @Autowired
    private OrderDetailsRepo orderDetailsRepo;

    public OrderDetails addOrderDetails(OrderDetails orderDetails){
        return add(orderDetails);
    }
    private OrderDetails add(OrderDetails orderDetails){
        return orderDetailsRepo.save(orderDetails);
    }
}
