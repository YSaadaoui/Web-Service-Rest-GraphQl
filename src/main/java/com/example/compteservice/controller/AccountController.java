package com.example.compteservice.controller;

import com.example.compteservice.dto.BankAccountRequestDTO;
import com.example.compteservice.dto.BankAccountResponseDto;
import com.example.compteservice.repos.AccountRepository;
import com.example.compteservice.service.IAccount;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class AccountController {

    AccountRepository accountRepository;
    private IAccount iAccount;




    @PostMapping("/bankAccounts")
    public BankAccountResponseDto save(@RequestBody BankAccountRequestDTO bankAccount){

       return iAccount.addAccount(bankAccount);
    }
//    @PutMapping("/bankAccounts/{id}")
//    public BankAccountResponseDto update(@RequestBody BankAccount bankAccount, @PathVariable String id){
//        return iAccount.update(bankAccount,id);
//    }
//
//    @GetMapping("/bankAccounts")
//    public List<BankAccountResponseDto> bankAccounts(){
//        return iAccount.listAccounts();
//    }
//    @GetMapping("/bankAccounts/{id}")
//    public BankAccountResponseDto bankAccount(@PathVariable String id){
//        return iAccount.getAccountById(id);
//    }
//    @DeleteMapping("/bankAccounts/{id}")
//    public void deleteAccount(@PathVariable String id){
//        iAccount.deleteAccount(id);
//    }
}
