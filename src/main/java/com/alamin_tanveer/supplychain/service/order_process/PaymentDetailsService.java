package com.alamin_tanveer.supplychain.service.order_process;

import com.alamin_tanveer.supplychain.converter.PaymentDetailsConverter;
import com.alamin_tanveer.supplychain.dto.response.ResponsePaymentDetailsDto;
import com.alamin_tanveer.supplychain.entities.order_process.PaymentDetails;
import com.alamin_tanveer.supplychain.enums.DealerPaymentStatus;
import com.alamin_tanveer.supplychain.repositories.order_process.PaymentDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@Service
public class PaymentDetailsService {
    @Autowired
    private PaymentDetailsRepo paymentDetailsRepo;
    @Autowired
    private PaymentDetailsConverter paymentDetailsConverter;


    public String getPaymentDetailsByInvoice(String username){
//        final boolean present = paymentDetailsRepo.findPaymentDetailsByUsername(username).isPresent();
//        if (present){
//            System.out.println(present);
//        }else {
//            System.out.println(present);
//        }
        try {
//            final PaymentDetails paymentDetailsByStatusAndUsername =
            final List<PaymentDetails> paymentDetails = getAllPaymentByUser(username);
            if (paymentDetails == null){
                return DealerPaymentStatus.DONE.toString();
            }

            for (PaymentDetails p : paymentDetails){
                if (p.getStatus().toString().equals(DealerPaymentStatus.INVOICE.toString())){
                    return DealerPaymentStatus.INVOICE.toString();
                }
            }
            return DealerPaymentStatus.DONE.toString();

//            return paymentDetailsRepo.getPaymentDetailsByStatusAndUsername(username, DealerPaymentStatus.INVOICE.toString());
//            return paymentDetailsByStatusAndUsername;
        }catch (Exception e){
            e.printStackTrace();
        }



        return null;
    }

    public PaymentDetails addPaymentDetails(PaymentDetails paymentDetails) {
        return paymentDetailsRepo.save(paymentDetails);
    }

    public List<ResponsePaymentDetailsDto> getAllPaymentDetails(String username){
        final List<PaymentDetails> allPaymentByUser = getAllPaymentByUser(username);
        if (allPaymentByUser != null){
            return paymentDetailsConverter.getAllResponsePaymentDetails(allPaymentByUser);
        }
        return null;
    }

    private List<PaymentDetails> getAllPaymentByUser(String username){
        return paymentDetailsRepo.findPaymentDetailsByUsername(username).orElse(null);
    }


}
