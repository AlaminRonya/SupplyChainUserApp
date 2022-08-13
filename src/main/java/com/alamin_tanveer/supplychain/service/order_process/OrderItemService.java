package com.alamin_tanveer.supplychain.service.order_process;

import com.alamin_tanveer.supplychain.dto.request.OrderCartItemDto;
import com.alamin_tanveer.supplychain.dto.response.ResponseCartItem;
import com.alamin_tanveer.supplychain.entities.order_process.OrderDetails;
import com.alamin_tanveer.supplychain.entities.order_process.OrderItem;
import com.alamin_tanveer.supplychain.entities.product.Product;
import com.alamin_tanveer.supplychain.repositories.order_process.OrderItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderItemService {
    @Autowired
    private OrderItemRepo orderItemRepo;
    @Autowired
    private CartItemService cartItemService;

    private final LocalDate localDate = LocalDate.now();

    public void addOrderItem(List<OrderCartItemDto> allOrder, OrderDetails orderDetails) {
        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderCartItemDto order : allOrder){
            OrderItem orderItem = new OrderItem();
            ResponseCartItem cartItemById = cartItemService.getCartItemById(order.getCartId());

            orderItem.setQuantity(Long.valueOf(order.getQty()));
            orderItem.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
            orderItem.setProduct(cartItemById.getProduct());
            orderItem.setOrderDetails(orderDetails);

            OrderItem save = orderItemRepo.save(orderItem);
            orderItems.add(save);
        }


    }
}
