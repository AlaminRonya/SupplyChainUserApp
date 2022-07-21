package com.alamin_tanveer.supplychain.registration.verification;

import com.alamin_tanveer.supplychain.repositories.third_party.NIDStorageRepo;
import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class NIDVerification implements Predicate<String> {

    private final NIDStorageRepo nidStorageRepo;

    public NIDVerification(NIDStorageRepo nidStorageRepo) {

        this.nidStorageRepo = nidStorageRepo;
    }

    @Override
    public boolean test(String s) {
//        TODO: third party api NID number and compare the registration NID number
        return nidStorageRepo.findByNid(s).isPresent();
    }
}
