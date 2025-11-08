package com.example.bankingApplication.service.impl;

import com.example.bankingApplication.dto.AccountDto;
import com.example.bankingApplication.entity.Account;
import com.example.bankingApplication.mapper.AccountMapper;
import com.example.bankingApplication.repo.AccountsRepo;
import com.example.bankingApplication.service.AddCoountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddAccountServiceImpl implements AddCoountService {
    private AccountsRepo accountsRepo;
    @Autowired
    public AddAccountServiceImpl(AccountsRepo accountsRepo) {
        this.accountsRepo = accountsRepo;
    }



    @Override
    public AccountDto addAccount(AccountDto accountDto) {
        Account account= AccountMapper.mapToAccount(accountDto);

       Account savedAccount= accountsRepo.save(account);

        return AccountMapper.AccountToDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account=accountsRepo.findById(id).orElseThrow(()-> {
            throw new RuntimeException("Accoount is not found with this id");
        });


            return AccountMapper.AccountToDto(account);


    }
}
