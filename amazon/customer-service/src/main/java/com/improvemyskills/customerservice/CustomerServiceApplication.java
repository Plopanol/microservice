package com.improvemyskills.customerservice;

import com.improvemyskills.customerservice.entity.Customer;
import com.improvemyskills.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class CustomerServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            customerRepository.saveAll(
                    List.of(
                            Customer.builder().firstName("Ahmadou").lastName("ABOUBAKAR").email("ahmadou.aboubakar@improvemyskills.com").build(),
                            Customer.builder().firstName("King").lastName("Tchala").email("king.tchala@improvemyskills.com").build(),
                            Customer.builder().firstName("Tony").lastName("STARK").email("tony.stark@improvemyskills.com").build()
                    )
            );
        };
    }
}
