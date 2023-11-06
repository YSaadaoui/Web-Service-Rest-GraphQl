package com.example.compteservice;

import com.example.compteservice.entities.Customer;
import com.example.compteservice.enums.AccountType;
import com.example.compteservice.entities.BankAccount;
import com.example.compteservice.repos.AccountRepository;
import com.example.compteservice.repos.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class CompteServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompteServiceApplication.class, args);
	}

@Bean
	CommandLineRunner start(AccountRepository accountRepository, CustomerRepository customerRepository){
		return  args -> {

			Stream.of("Mohamed","Ysssine","Hanae","Imane").forEach(c->{
				Customer customer=Customer.builder()
						.name(c)
						.build();
				customerRepository.save(customer);
			});

			customerRepository.findAll().forEach(customer -> {
				for (int i=0;i<10;i++){
					BankAccount bankAccount=BankAccount.builder()
							.id(UUID.randomUUID().toString())
							.type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
							.balance(1000+Math.random()*90000)
							.createdAt(new Date())
							.currency("MAD")
							.build();

					accountRepository.save(bankAccount);
				}
			});

		};
	}
}
