package com.alamin_tanveer.supplychain.service.bank;

import com.alamin_tanveer.supplychain.entities.bank.Customer;
import com.alamin_tanveer.supplychain.entities.bank.account.Account;
import com.alamin_tanveer.supplychain.entities.bank.account.Bank;
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

    public void add(){
        Customer customer = new Customer();
        customer.setCustomerName("Md. Rony");
        customer.setAccountNumber("12345670");
        customer.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));

        Customer cus = customerRepo.save(customer);

        Account account = new Account();
        account.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        account.setAccountNumber(customer.getAccountNumber());
        Account acc = accountRepo.save(account);

        Bank bank = new Bank();
        bank.setBankName("DBBL");
        bank.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        bank.setCustomer(cus);
        bank.setAccount(acc);
        bankRepo.save(bank);
    }

    public List<Bank> insert(List<Customer> customers){



        List<Bank> banks = new ArrayList<>();


        for (Customer customer: customers){
            Customer cus = customerRepo.save(customer);

            Account account = new Account();
            account.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
            account.setAccountNumber(customer.getAccountNumber());
            Account acc = accountRepo.save(account);

            Bank bank = new Bank();
            bank.setBankName("DBBL");
            bank.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
            bank.setCustomer(cus);
            bank.setAccount(acc);

            banks.add(bank);



        }
        return bankRepo.saveAll(banks);

    }


}
