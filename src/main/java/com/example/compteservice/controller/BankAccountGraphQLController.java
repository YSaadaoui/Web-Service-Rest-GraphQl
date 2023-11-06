package com.example.compteservice.controller;

import com.example.compteservice.dto.BankAccountRequestDTO;
import com.example.compteservice.dto.BankAccountResponseDto;
import com.example.compteservice.entities.BankAccount;
import com.example.compteservice.entities.Customer;
import com.example.compteservice.repos.AccountRepository;
import com.example.compteservice.repos.CustomerRepository;
import com.example.compteservice.service.IAccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class BankAccountGraphQLController {
    private AccountRepository iAccount;
    private IAccount iAccou;
    private CustomerRepository customerRepository;
    @QueryMapping
    public List<BankAccount> accountList(){
        return iAccount.findAll();
    }
    @QueryMapping
    public BankAccount accountById(@Argument String id){
        return iAccount.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
    }
    @MutationMapping
    public BankAccountResponseDto addAccount(@Argument BankAccountRequestDTO bankAccount){
        return  iAccou.addAccount(bankAccount);
    }

    @MutationMapping
    public BankAccountResponseDto update(@Argument String id,@Argument BankAccountRequestDTO bankAccount){
        return iAccou.updateAccount(id, bankAccount);
    }
    @MutationMapping
    public Boolean deleteAccount(@Argument String id){
        iAccount.deleteById(id);
        return true;
    }
    @QueryMapping
    public List<Customer> customers(){
        return customerRepository.findAll();
    }

}
@Data @NoArgsConstructor @AllArgsConstructor
class BankAccountDTO{
   private  String type;
   private Double balance;
   private String currency;
}