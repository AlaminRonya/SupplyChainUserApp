package com.alamin_tanveer.supplychain.service.order_process;

import com.alamin_tanveer.supplychain.appuser.AppUser;
import com.alamin_tanveer.supplychain.appuser.AppUserService;
import com.alamin_tanveer.supplychain.converter.CheckoutConverter;
import com.alamin_tanveer.supplychain.dto.request.CheckoutDto;
import com.alamin_tanveer.supplychain.dto.request.OrderCartItemDto;
import com.alamin_tanveer.supplychain.entities.Dealer;
import com.alamin_tanveer.supplychain.entities.order_process.Checkout;
import com.alamin_tanveer.supplychain.entities.order_process.OrderDetails;
import com.alamin_tanveer.supplychain.entities.order_process.PaymentDetails;
import com.alamin_tanveer.supplychain.enums.DealerPaymentStatus;
import com.alamin_tanveer.supplychain.service.DealerService;
import com.alamin_tanveer.supplychain.service.bank.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private CartItemService cartItemService;
    @Autowired
    private AppUserService appUserService;
    @Autowired
    private CheckoutService checkoutService;
    @Autowired
    private PaymentDetailsService paymentDetailsService;
    @Autowired
    private OrderDetailsService orderDetailsService;
    @Autowired
    private OrderItemService orderItemService;
    @Autowired
    private BankService bankService;

    @Autowired
    private DealerService dealerService;


    private final LocalDate localDate = LocalDate.now();


    public void orderDealer(CheckoutDto dto) {

        final Dealer dealer = dealerService.getDealerByAppUser(dto.getUsername());


        final Double totalPrice = cartItemService.getTotalPriceAndOthers();
        // INVOICE Check
        final String invoice = paymentDetailsService.getPaymentDetailsByInvoice(dto.getUsername());


        if (dto.getAmount() < totalPrice/2 || invoice.equals("INVOICE") || dealer == null){
            System.out.println("======================================Not Order================");
        }else {
            final List<OrderCartItemDto> allOrder = getAllOrder(dto.getUsername());
            final AppUser appUser = appUserService.getUser(dto.getUsername());

            if (!dto.getAccountNumber().equals(dealer.getUserBankAccountNumber())){
                return;
            }


            if (allOrder != null && appUser != null){
                final Boolean withdraw = bankService.withdraw(dto.getAccountNumber(), dto.getAmount());
                final DealerPaymentStatus status;
                if (withdraw){
                    if (dto.getAmount().equals(totalPrice)){
                        status = DealerPaymentStatus.DONE;
                    }else {
                        status = DealerPaymentStatus.INVOICE;
                    }
                    double due = totalPrice - dto.getAmount();
                    final PaymentDetails paymentDetails = addPaymentDetails(dto.getUsername(), dto.getAmount(), status, due);
                    final OrderDetails orderDetails = addOrderDetails(dto.getUsername(), paymentDetails, appUser);
                    addOrderItem(allOrder, orderDetails);

                    checkoutService.addCheckout(dto);


                }
            }

        }


    }

    private void addOrderItem(List<OrderCartItemDto> allOrder, OrderDetails orderDetails){
        orderItemService.addOrderItem(allOrder, orderDetails);

    }

    private OrderDetails addOrderDetails(String username, PaymentDetails paymentDetails, AppUser appUser){
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setUsername(username);
        orderDetails.setQuantity(Long.valueOf(cartItemService.getTotalCarton()));
        orderDetails.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        orderDetails.setTotal(cartItemService.getTotalPriceAndOthers());
        orderDetails.setUser(appUser);
        orderDetails.setPayment(paymentDetails);

        return orderDetailsService.addOrderDetails(orderDetails);
    }
    private PaymentDetails addPaymentDetails(String username, Double amount, DealerPaymentStatus status, Double due){
        PaymentDetails paymentDetails = new PaymentDetails();
        paymentDetails.setAmount(amount);
        paymentDetails.setDue(due);
        paymentDetails.setUsername(username);
        paymentDetails.setStatus(status);
        paymentDetails.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        return paymentDetailsService.addPaymentDetails(paymentDetails);

    }
    private List<OrderCartItemDto> getAllOrder(String username){
        return cartItemService.orderDealer(username);
    }
}
