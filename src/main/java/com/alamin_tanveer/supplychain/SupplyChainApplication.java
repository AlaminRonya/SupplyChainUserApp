package com.alamin_tanveer.supplychain;

import com.alamin_tanveer.supplychain.entities.bank.Customer;
import com.alamin_tanveer.supplychain.entities.bank.account.Account;
import com.alamin_tanveer.supplychain.entities.bank.account.Bank;
import com.alamin_tanveer.supplychain.entities.third_party.NIDStorage;
import com.alamin_tanveer.supplychain.entities.third_party.TINStorage;
import com.alamin_tanveer.supplychain.repositories.bank.AccountRepo;
import com.alamin_tanveer.supplychain.repositories.bank.BankRepo;
import com.alamin_tanveer.supplychain.repositories.bank.CustomerRepo;
import com.alamin_tanveer.supplychain.repositories.third_party.NIDStorageRepo;
import com.alamin_tanveer.supplychain.repositories.third_party.TINStorageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SupplyChainApplication {
//    @Autowired
//    private CustomerRepo customerRepo;
//    @Autowired
//    private BankRepo bankRepo;
//    @Autowired
//    private AccountRepo accountRepo;

    private LocalDate localDate = LocalDate.now();

    public static void main(String[] args) {
        SpringApplication.run(SupplyChainApplication.class, args);
    }

    @Bean
    CommandLineRunner addNID(NIDStorageRepo repo){
        return args -> {

            NIDStorage nidStorage = new NIDStorage();
            nidStorage.setNid("1234567890");

            NIDStorage nidStorage1 = new NIDStorage();
            nidStorage1.setNid("1234567891");

            NIDStorage nidStorage2 = new NIDStorage();
            nidStorage2.setNid("1234567892");

            NIDStorage nidStorage3 = new NIDStorage();
            nidStorage3.setNid("1234567893");

            NIDStorage nidStorage4 = new NIDStorage();
            nidStorage4.setNid("1234567894");

            NIDStorage nidStorage5 = new NIDStorage();
            nidStorage5.setNid("1234567895");

            NIDStorage nidStorage6 = new NIDStorage();
            nidStorage6.setNid("1234567896");

            NIDStorage nidStorage7 = new NIDStorage();
            nidStorage7.setNid("1234567897");



            repo.saveAll(List.of(nidStorage, nidStorage1, nidStorage2, nidStorage3, nidStorage4, nidStorage5,
                    nidStorage6, nidStorage7));

        };
    }

    @Bean
    CommandLineRunner addTID(TINStorageRepo repo){
        return args -> {
            List<TINStorage> storages = new ArrayList<>();

            TINStorage tinStorage = new TINStorage();
            tinStorage.setTinId("1234567890");
            storages.add(tinStorage);
            TINStorage tinStorage1 = new TINStorage();
            tinStorage1.setTinId("1234567891");
            storages.add(tinStorage1);
            TINStorage tinStorage2 = new TINStorage();
            tinStorage2.setTinId("1234567892");
            storages.add(tinStorage2);
            TINStorage tinStorage3 = new TINStorage();
            tinStorage3.setTinId("1234567893");
            storages.add(tinStorage3);
            TINStorage tinStorage4 = new TINStorage();
            tinStorage4.setTinId("1234567894");
            storages.add(tinStorage4);
            TINStorage tinStorage5 = new TINStorage();
            tinStorage5.setTinId("1234567895");
            storages.add(tinStorage5);
            TINStorage tinStorage6 = new TINStorage();
            tinStorage6.setTinId("1234567896");
            storages.add(tinStorage6);
            TINStorage tinStorage7 = new TINStorage();
            tinStorage7.setTinId("1234567897");
            storages.add(tinStorage7);


            repo.saveAll(storages);

        };
    }


//
//    @Bean
//    CommandLineRunner addCustomer(CustomerRepo customerRepo, BankRepo bankRepo, AccountRepo accountRepo){
//        return args ->{
//
//            List<Customer> customers = new ArrayList<>();
//
//            Customer customer = new Customer();
//            customer.setCustomerName("Md. Rony");
//            customer.setAccountNumber("12345670");
//            customer.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
//            customers.add(customer);
//
//            Customer customer1 = new Customer();
//            customer1.setCustomerName("Md. Rony");
//            customer1.setAccountNumber("12345671");
//            customer1.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
//            customers.add(customer1);
//
//            Customer customer2 = new Customer();
//            customer2.setCustomerName("Md. Rony");
//            customer2.setAccountNumber("12345672");
//            customer2.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
//            customers.add(customer2);
//
//            Customer customer3 = new Customer();
//            customer3.setCustomerName("Md. Rony");
//            customer3.setAccountNumber("12345673");
//            customer3.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
//            customers.add(customer3);
//
//            Customer customer4 = new Customer();
//            customer4.setCustomerName("Md. Rony");
//            customer4.setAccountNumber("12345674");
//            customer4.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
//            customers.add(customer4);
//
//            final List<Customer> customers1 = customerRepo.saveAll(customers);
//
//
//            List<Account> accounts = new ArrayList<>();
//
//            Account account = new Account();
//            account.setAccountNumber(customers1.get(0).getAccountNumber());
//            account.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
//            accounts.add(account);
//
//            Account account1 = new Account();
//            account1.setAccountNumber(customers1.get(1).getAccountNumber());
//            account1.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
//            accounts.add(account1);
//
//            Account account2 = new Account();
//            account2.setAccountNumber(customers1.get(2).getAccountNumber());
//            account2.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
//            accounts.add(account2);
//
//            Account account3 = new Account();
//            account3.setAccountNumber(customers1.get(3).getAccountNumber());
//            account3.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
//            accounts.add(account3);
//            Account account4 = new Account();
//            account4.setAccountNumber(customers1.get(4).getAccountNumber());
//            account4.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
//            accounts.add(account4);
//
//            final List<Account> accounts1 = accountRepo.saveAll(accounts);
//
//            List<Bank> banks = new ArrayList<>();
//
//            Bank bank = new Bank();
//            bank.setBankName("DBBL");
//            bank.setAccount(accounts1.get(0));
//            bank.setCustomer(customers1.get(0));
//            bank.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
//            banks.add(bank);
//
//            Bank bank1 = new Bank();
//            bank1.setBankName("DBBL");
//            bank1.setAccount(accounts1.get(1));
//            bank1.setCustomer(customers1.get(1));
//            bank1.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
//            banks.add(bank1);
//
//            Bank bank2 = new Bank();
//            bank2.setBankName("DBBL");
//            bank2.setAccount(accounts1.get(2));
//            bank2.setCustomer(customers1.get(2));
//            bank2.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
//            banks.add(bank2);
//
//            Bank bank3 = new Bank();
//            bank3.setBankName("DBBL");
//            bank3.setAccount(accounts1.get(3));
//            bank3.setCustomer(customers1.get(3));
//            bank3.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
//            banks.add(bank3);
//
//            Bank bank4 = new Bank();
//            bank4.setBankName("DBBL");
//            bank4.setAccount(accounts1.get(4));
//            bank4.setCustomer(customers1.get(4));
//            bank4.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
//            banks.add(bank4);
//
//            bankRepo.saveAll(banks);
//
//        };
//
//    }
}
