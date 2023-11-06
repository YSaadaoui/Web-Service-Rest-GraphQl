package com.example.compteservice.service.impl;

import com.example.compteservice.dto.BankAccountRequestDTO;
import com.example.compteservice.dto.BankAccountResponseDto;
import com.example.compteservice.mapper.BankAccountMapper;
import com.example.compteservice.entities.BankAccount;
import com.example.compteservice.repos.AccountRepository;
import com.example.compteservice.service.IAccount;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class AccountImpl implements IAccount {
    AccountRepository accountRepository;
    BankAccountMapper bankAccountMapper;

//
//
//    @Override
//    public List<BankAccountResponseDto> listAccounts() {
//        return accountRepository.findAll().stream().map(bankAccountMapper::from).collect(Collectors.toList());
//    }
//
//    @Override
//    public BankAccountResponseDto getAccountById(String id) {
//        BankAccount bankAccount = accountRepository.findById(id).orElse(null);
//        if (bankAccount==null) throw new RuntimeException(String.format("Account %s not found"));
//            return bankAccountMapper.from(bankAccount);
//    }
//
//    @Override
//    public BankAccountResponseDto update(BankAccount request, String id) {
//        BankAccount account =accountRepository.findById(id).orElseThrow();
//        if(request.getBalance()!=null) account.setBalance(request.getBalance());
//        if(request.getCreatedAt()!=null) account.setCreatedAt(new Date());
//        if(request.getType()!=null)account.setType(request.getType());
//        if(request.getCurrency()!=null)account.setCurrency(request.getCurrency());
//         accountRepository.save(account);
//        return bankAccountMapper.from(request);
//    }
//
//    @Override
//    public void deleteAccount(String id) {
//        BankAccount customer = accountRepository.findById(id).orElse(null);
//        if (customer==null) throw new RuntimeException(String.format("Account %s not found"));
//        accountRepository.deleteById(id);
//    }

    @Override
    public BankAccountResponseDto addAccount(BankAccountRequestDTO bankAccountRequestDTO) {
      BankAccount bankAccount=BankAccount.builder().
              id(UUID.randomUUID().toString())
              .createdAt(new Date())
              .balance(bankAccountRequestDTO.getBalance())
              .type(bankAccountRequestDTO.getType())
              .currency(bankAccountRequestDTO.getCurrency())
              .build();
      BankAccount bankAccount1=accountRepository.save(bankAccount);
//      BankAccountResponseDto bankAccountResponseDto=BankAccountResponseDto.builder()
//              .id(bankAccount1.getId()).createdAt(bankAccount1.getCreatedAt()).balance(bankAccount1.getBalance()).type(bankAccount1.getType()).currency(bankAccount1.getCurrency())
//                      .build();
        return bankAccountMapper.fromBankAccount(bankAccount1);
    }

    @Override
    public BankAccountResponseDto updateAccount(String id, BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount=BankAccount.builder().
                id(id)
                .createdAt(new Date())
                .balance(bankAccountRequestDTO.getBalance())
                .type(bankAccountRequestDTO.getType())
                .currency(bankAccountRequestDTO.getCurrency())
                .build();
        BankAccount bankAccount1=accountRepository.save(bankAccount);
//
        return bankAccountMapper.fromBankAccount(bankAccount1);


    }


}
