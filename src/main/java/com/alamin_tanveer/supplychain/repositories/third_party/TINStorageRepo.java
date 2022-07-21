package com.alamin_tanveer.supplychain.repositories.third_party;

import com.alamin_tanveer.supplychain.entities.third_party.TINStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface TINStorageRepo extends JpaRepository<TINStorage, Long> {

    Optional<TINStorage> findByTinId(String tinId);
}
