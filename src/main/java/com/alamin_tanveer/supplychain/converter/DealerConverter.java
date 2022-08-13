package com.alamin_tanveer.supplychain.converter;

import com.alamin_tanveer.supplychain.dto.request.DealerDto;
import com.alamin_tanveer.supplychain.entities.Dealer;
import com.alamin_tanveer.supplychain.utils.DateUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Component
public class DealerConverter {
    private final LocalDate localDate = LocalDate.now();

    public Dealer getDtoToPojo(DealerDto dto){
        Dealer dealer = new Dealer();
        dealer.setUsername(dto.getUsername());
        dealer.setPhoneNumber(dto.getPhoneNumber());
        dealer.setDob(DateUtils.convertToDateViaInstant(dto.getDob()));
        dealer.setUserNID(dto.getUserNID());
        dealer.setUserBankAccountNumber(dto.getUserBankAccountNumber());
        dealer.setTradeLicenseNumber(dto.getTradeLicenseNumber());
        dealer.setGender(dto.getGender());
        dealer.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));

        return dealer;
    }
}
