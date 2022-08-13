package com.alamin_tanveer.supplychain.repositories.order_process;

import com.alamin_tanveer.supplychain.entities.order_process.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface OrderDetailsRepo extends JpaRepository<OrderDetails, Long> {

    Optional<List<OrderDetails>> findOrderDetailsByUsername(String username);

}
