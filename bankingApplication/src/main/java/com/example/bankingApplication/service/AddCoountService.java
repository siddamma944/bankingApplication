package com.example.bankingApplication.service;

import com.example.bankingApplication.dto.AccountDto;

public interface AddCoountService {
    public AccountDto addAccount(AccountDto accountDto);

    public AccountDto getAccountById(Long id);
}
