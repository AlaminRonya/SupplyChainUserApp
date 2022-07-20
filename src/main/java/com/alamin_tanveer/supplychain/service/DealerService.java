package com.alamin_tanveer.supplychain.service;

import com.alamin_tanveer.supplychain.dto.request.DealerDto;
import com.alamin_tanveer.supplychain.repositories.DealerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DealerService {
    @Autowired
    private DealerRepo dealerRepo;

    public void insert(DealerDto dto){

//        dealerRepo.save();
    }
}
