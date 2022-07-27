package com.alamin_tanveer.supplychain.service.thirt_party;

import com.alamin_tanveer.supplychain.entities.third_party.NIDStorage;
import com.alamin_tanveer.supplychain.entities.third_party.TINStorage;
import com.alamin_tanveer.supplychain.repositories.third_party.TINStorageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TINStorageService {
    @Autowired
    private TINStorageRepo tinStorageRepo;

    public void addTinStorage(List<TINStorage> tinStorages){
        for (TINStorage tin: tinStorages){
            final boolean present = tinStorageRepo.findByTinId(tin.getTinId()).isPresent();
            if (!present){
                tinStorageRepo.save(tin);
            }
        }

    }
}
