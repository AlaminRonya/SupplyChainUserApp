package com.alamin_tanveer.supplychain.service.bank;

import com.alamin_tanveer.supplychain.entities.bank.Customer;
import com.alamin_tanveer.supplychain.entities.bank.account.Account;
import com.alamin_tanveer.supplychain.entities.bank.account.Bank;
import com.alamin_tanveer.supplychain.entities.third_party.TINStorage;
import com.alamin_tanveer.supplychain.repositories.bank.AccountRepo;
import com.alamin_tanveer.supplychain.repositories.bank.BankRepo;
import com.alamin_tanveer.supplychain.repositories.bank.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private BankRepo bankRepo;
    @Autowired
    private AccountRepo accountRepo;
    private final LocalDate localDate = LocalDate.now();


    public void addListOfCustomer(){
        List<Customer> customers = new ArrayList<>();
        for (int i=0; i<10; i++){
            Customer customer = new Customer();
            customer.setCustomerName("Md. Rony");
            customer.setAccountNumber("1234567"+i);
            customer.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
            customers.add(customer);
        }
        for (Customer customer: customers){
            final boolean present = customerRepo.findByAccountNumber(customer.getAccountNumber()).isPresent();
            if (!present){

                final Customer save = customerRepo.save(customer);

                final Account account = new Account();
                account.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                account.setAccountNumber(customer.getAccountNumber());

                final Account acc = accountRepo.save(account);

                final Bank bank = new Bank();
                bank.setBankName("DBBL");
                bank.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                bank.setCustomer(save);
                bank.setAccount(acc);

                bankRepo.save(bank);
            }
        }
    }


}
