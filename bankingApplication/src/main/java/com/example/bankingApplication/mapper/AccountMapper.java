package com.example.bankingApplication.mapper;

import com.example.bankingApplication.dto.AccountDto;
import com.example.bankingApplication.entity.Account;

public class AccountMapper {

    public static AccountDto AccountToDto(Account account){
       AccountDto accountDto= new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()

        );
       return accountDto;
    }

    public static Account mapToAccount(AccountDto AccountDto ){
        Account account=new Account(                AccountDto.getId(),
                AccountDto.getAccountHolderName(),
                AccountDto.getBalance());
        return account;
    }

}
