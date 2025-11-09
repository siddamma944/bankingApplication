package com.example.bankingApplication.service.impl;

import com.example.bankingApplication.dto.AccountDto;
import com.example.bankingApplication.entity.Account;
import com.example.bankingApplication.exception.AccountException;
import com.example.bankingApplication.mapper.AccountMapper;
import com.example.bankingApplication.repo.AccountsRepo;
import com.example.bankingApplication.service.AddCoountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


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
            throw new AccountException("Accoount is not found with this id");
        });


            return AccountMapper.AccountToDto(account);


    }

    @Override
    public AccountDto deposit(Long id, Double amount) {
        Account account=accountsRepo.findById(id).orElseThrow(()->{
            throw new AccountException("account is not fount with that id");

        });
        double totalAmount=account.getBalance()+amount;
        account.setBalance(totalAmount);
      Account finalresultAccount=  accountsRepo.save(account);
        AccountDto accountDto=AccountMapper.AccountToDto(finalresultAccount);

        return accountDto;
    }

    @Override
    public AccountDto withDraw(Long id, Double amount) {

        Account account=accountsRepo.findById(id).orElseThrow(()->{
            throw new AccountException("account is not fount with that id");

        });
        if(account.getBalance()>amount) {
            double remainingAmount = account.getBalance() - amount;

            account.setBalance(remainingAmount);
        }
        else{
            throw new AccountException("Insufiecent amount");
        }
        Account finalAccount=accountsRepo.save(account);


        return AccountMapper.AccountToDto(finalAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts=accountsRepo.findAll();
        List<AccountDto> listofAccount=accounts.stream().map((Account account)->AccountMapper.AccountToDto(account)).collect(Collectors.toList());

        return listofAccount;
    }

    @Override
    public void deleteById(Long id) {
        Account account=accountsRepo.findById(id).orElseThrow(()-> {
            throw new AccountException("account is not exist with this id " + id);

        });
        accountsRepo.deleteById(id);
    }
}
