package com.example.bankingApplication.service;

import com.example.bankingApplication.dto.AccountDto;

import java.util.List;

public interface AddCoountService {
    public AccountDto addAccount(AccountDto accountDto);

    public AccountDto getAccountById(Long id);

    public AccountDto deposit(Long id, Double amount);

    public AccountDto withDraw(Long id, Double amount);

    public List<AccountDto> getAllAccounts();

    public void deleteById(Long id);

}
