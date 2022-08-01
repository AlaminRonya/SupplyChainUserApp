package com.alamin_tanveer.supplychain;

import com.alamin_tanveer.supplychain.appuser.AppUser;
import com.alamin_tanveer.supplychain.appuser.AppUserRole;
import com.alamin_tanveer.supplychain.appuser.AppUserService;
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
import com.alamin_tanveer.supplychain.service.bank.CustomerService;
import com.alamin_tanveer.supplychain.service.thirt_party.NIDStorageService;
import com.alamin_tanveer.supplychain.service.thirt_party.TINStorageService;
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

    public static void main(String[] args) {
        SpringApplication.run(SupplyChainApplication.class, args);
    }

    @Bean
    CommandLineRunner addNID(NIDStorageService service){
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



            service.addNIDStorage(List.of(nidStorage, nidStorage1, nidStorage2, nidStorage3, nidStorage4, nidStorage5,
                    nidStorage6, nidStorage7));

        };
    }

    @Bean
    CommandLineRunner addTID(TINStorageService service){
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


            service.addTinStorage(storages);

        };
    }


//    @Bean
//    CommandLineRunner addListOfCustomer(CustomerService service){
//        return args -> {
//            service.addListOfCustomer();
//        };
//    }

    @Bean
    CommandLineRunner addAppUser(AppUserService service){
        return args -> {
            AppUser user = new AppUser("User", "user@gmail.com","asdfHp00@", AppUserRole.USER);
            AppUser dealer = new AppUser("User", "dealer@gmail.com","asdfHp00@", AppUserRole.DEALER_USER);
//            AppUser accountManager = new AppUser("User", "account_manager@gmail.com","asdfHp00@", AppUserRole.ACCOUNT_MANAGER);
            service.addUserTest(user);
            service.addUserTest(dealer);
        };
    }


//   end of working code


}
