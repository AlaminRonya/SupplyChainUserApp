package com.alamin_tanveer.supplychain.repositories.order_process;

import com.alamin_tanveer.supplychain.entities.order_process.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartItemRepo extends JpaRepository<CartItem, Long> {

    @Query("Select c  FROM CartItem c WHERE c.product.id= :product_id and c.username=:user_name")
    Optional<CartItem> getCartByProductIdAndUsername(Long product_id, String user_name);

    @Query("Select c  FROM CartItem c WHERE  c.username=:user_name")
    Optional<List<CartItem>> getCartByProductUsername(String user_name);


}
