package com.alamin_tanveer.supplychain.registration.verification;

import com.alamin_tanveer.supplychain.repositories.third_party.TINStorageRepo;
import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class TradeLicenseVerification implements Predicate<String> {

    private final TINStorageRepo tinStorageRepo;

    public TradeLicenseVerification(TINStorageRepo tinStorageRepo) {

        this.tinStorageRepo = tinStorageRepo;
    }

    @Override
    public boolean test(String s) {
//      TODO: third party api trade license number and compare the registration trade license number
        return tinStorageRepo.findByTinId(s).isPresent();
    }
}
