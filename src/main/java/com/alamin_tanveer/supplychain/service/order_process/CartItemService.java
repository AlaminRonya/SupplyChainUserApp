package com.alamin_tanveer.supplychain.service.order_process;

import com.alamin_tanveer.supplychain.converter.ProductConverter;
import com.alamin_tanveer.supplychain.dto.response.ResponseProductDto;
import com.alamin_tanveer.supplychain.entities.order_process.CartItem;
import com.alamin_tanveer.supplychain.entities.product.Product;
import com.alamin_tanveer.supplychain.repositories.order_process.CartItemRepo;
import com.alamin_tanveer.supplychain.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CartItemService {
    @Autowired
    private CartItemRepo cartItemRepo;
    @Autowired
    private ProductService productService;

    private LocalDate localDate = LocalDate.now();


    public Boolean addToCartItem(Long productId, String username){
        System.out.println(productId+" : "+username);
        final CartItem search = search(productId, username);
        System.out.println(search);
        final Product productAddCardItem = productService.getProduct(productId);

        if (search == null && productAddCardItem != null){
            CartItem cartItem = new CartItem();
            cartItem.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
            cartItem.setUsername(username);
            cartItem.setProduct(productAddCardItem);

            cartItemRepo.save(cartItem);
            return true;
        }
        System.out.println("All ready exist");
        return false;

    }

    public ResponseProductDto getResponseProductById(Long id){
        return productService.getProductAddCardItem(id);
    }

    public List<CartItem> getAllCartItem(){
        return cartItemRepo.getCartByProductUsername(SecurityContextHolder.getContext().getAuthentication().getName()).orElse(null);
    }


    private CartItem search(Long productId, String username){
        return cartItemRepo.getCartByProductIdAndUsername(productId, username).orElse(null);
    }
}
