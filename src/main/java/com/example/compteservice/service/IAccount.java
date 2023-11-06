package com.example.compteservice.service;

import com.example.compteservice.dto.BankAccountRequestDTO;
import com.example.compteservice.dto.BankAccountResponseDto;

public interface IAccount {

   // BankAccount save(BankAccountResponseDto request);
//
//    List<BankAccountResponseDto> listAccounts();
//
//    BankAccountResponseDto getAccountById(String id);
//
//    BankAccountResponseDto update(BankAccount request, String id);

   // void deleteAccount(String id);


    BankAccountResponseDto addAccount(BankAccountRequestDTO bankAccountRequestDTO);

    BankAccountResponseDto updateAccount(String id, BankAccountRequestDTO bankAccountRequestDTO);
}
