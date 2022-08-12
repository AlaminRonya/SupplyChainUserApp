package com.alamin_tanveer.supplychain.converter;

import com.alamin_tanveer.supplychain.dto.response.ResponseCartItem;
import com.alamin_tanveer.supplychain.entities.order_process.CartItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CartItemConverter {

    public ResponseCartItem getResponseCartItem(CartItem cartItem){
        return ResponseCartItem.builder()
                .id(cartItem.getId())
                .username(cartItem.getUsername())
                .quantity(cartItem.getQuantity())
                .createdAt(cartItem.getCreatedAt())
                .product(cartItem.getProduct())
                .build();
    }

    public List<ResponseCartItem> getAllResponseCartItem(List<CartItem> cartItems){
        return cartItems.stream().map(this::getResponseCartItem).toList();
    }
}
