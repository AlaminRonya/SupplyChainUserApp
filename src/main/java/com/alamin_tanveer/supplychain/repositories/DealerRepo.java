package com.alamin_tanveer.supplychain.repositories;

import com.alamin_tanveer.supplychain.entities.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealerRepo  extends JpaRepository<Dealer, Long> {

}
