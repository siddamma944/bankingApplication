package com.example.bankingApplication.controller;

import com.example.bankingApplication.dto.AccountDto;
import com.example.bankingApplication.service.AddCoountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    private AddCoountService  AddCoountService;
    @Autowired
    public AccountController(AddCoountService addCoountService) {
        AddCoountService = addCoountService;
    }
    @PostMapping("/addAccount")
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto AccountDto){
       AccountDto accountDto= AddCoountService.addAccount(AccountDto);
       return ResponseEntity.ok(accountDto);

    }
    @GetMapping("account/{id}")
    public ResponseEntity<AccountDto> getById(@PathVariable Long id){

        AccountDto Account=AddCoountService.getAccountById(id);
        return new ResponseEntity<>(Account, HttpStatus.OK);
    }


}
