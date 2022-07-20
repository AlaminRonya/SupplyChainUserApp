package com.alamin_tanveer.supplychain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class SupplyChainApplication {
//    private LocalDate localDate = LocalDate.now();

    public static void main(String[] args) {
        SpringApplication.run(SupplyChainApplication.class, args);
    }

//    @Bean
//    CommandLineRunner addCustomer(CustomerService service){
//        return args ->{
//
//            List<Customer> customers = new ArrayList<>();
//            for (int i=0; i<5; i++){
//                Customer customer = new Customer();
//                customer.setCustomerName("Md. Rony");
//                customer.setAccountNumber("1234567"+i);
//                customer.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
//                customers.add(customer);
//            }
//           service.insert(customers);
//        };
//
//    }
}
