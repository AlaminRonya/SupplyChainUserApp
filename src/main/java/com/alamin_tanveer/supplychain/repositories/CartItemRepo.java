package com.alamin_tanveer.supplychain.repositories;

import com.alamin_tanveer.supplychain.entities.order_proccess.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepo extends JpaRepository<CartItem, Long> {
}
