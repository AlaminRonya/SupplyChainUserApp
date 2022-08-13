package com.alamin_tanveer.supplychain.converter;

import com.alamin_tanveer.supplychain.dto.response.ResponsePaymentDetailsDto;
import com.alamin_tanveer.supplychain.entities.order_process.PaymentDetails;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PaymentDetailsConverter {
    public ResponsePaymentDetailsDto getResponsePaymentDetails(PaymentDetails paymentDetails){
        ResponsePaymentDetailsDto dto = new ResponsePaymentDetailsDto();
        dto.setId(paymentDetails.getId());
        dto.setUsername(paymentDetails.getUsername());
        dto.setAmount(paymentDetails.getAmount());
        dto.setDue(paymentDetails.getDue());
        dto.setCreatedAt(paymentDetails.getCreatedAt());
        dto.setModifiedAt(paymentDetails.getModifiedAt());
        dto.setStatus(paymentDetails.getStatus().toString());

        return dto;
    }

    public List<ResponsePaymentDetailsDto> getAllResponsePaymentDetails(List<PaymentDetails> paymentDetails){
        return paymentDetails.stream().map(this::getResponsePaymentDetails).toList();
    }
}
