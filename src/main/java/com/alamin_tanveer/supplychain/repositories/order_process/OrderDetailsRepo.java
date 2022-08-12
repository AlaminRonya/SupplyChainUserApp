package com.alamin_tanveer.supplychain.repositories.order_process;

import com.alamin_tanveer.supplychain.entities.order_process.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepo extends JpaRepository<OrderDetails, Long> {
}
