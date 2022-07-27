package com.alamin_tanveer.supplychain.service.thirt_party;

import com.alamin_tanveer.supplychain.entities.third_party.NIDStorage;
import com.alamin_tanveer.supplychain.repositories.third_party.NIDStorageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NIDStorageService {
    @Autowired
    private NIDStorageRepo nidStorageRepo;

    public void addNIDStorage(List<NIDStorage> nidStorages){
        for (NIDStorage nid: nidStorages){
            final boolean present = nidStorageRepo.findByNid(nid.getNid()).isPresent();
            if (!present){
                nidStorageRepo.save(nid);
            }
        }
    }
}
