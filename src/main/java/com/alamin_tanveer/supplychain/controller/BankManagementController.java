package com.alamin_tanveer.supplychain.controller;

import com.alamin_tanveer.supplychain.entities.bank.Customer;
import com.alamin_tanveer.supplychain.service.bank.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class BankManagementController {
    @Autowired
    private CustomerService customerService;
    private LocalDate localDate = LocalDate.now();
    private static int m = 0;

    @GetMapping
    public void addBank(){

        List<Customer> customers = new ArrayList<>();
        for (int i=0; i<5; i++){
            Customer customer = new Customer();
            customer.setCustomerName("Md. Rony");
            customer.setAccountNumber("1234567"+i);
            customer.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
            customers.add(customer);
        }
        if (m==0){
            customerService.insert(customers);
            m=1;
        }

    }

}
