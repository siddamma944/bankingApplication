package com.example.bankingApplication.controller;

import com.example.bankingApplication.dto.AccountDto;
import com.example.bankingApplication.entity.Account;
import com.example.bankingApplication.service.AddCoountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/account")
public class AccountController {


    private AddCoountService  addCoountService;

    @Autowired
    public AccountController(AddCoountService addCoountService) {
        this.addCoountService = addCoountService;
    }

    @PostMapping("/addAccount")
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto AccountDto){
       AccountDto accountDto= addCoountService.addAccount(AccountDto);
       return ResponseEntity.ok(accountDto);

    }
    @GetMapping("account/{id}")
    public ResponseEntity<AccountDto> getById(@PathVariable Long id){

        AccountDto Account=addCoountService.getAccountById(id);
        return new ResponseEntity<>(Account, HttpStatus.OK);
    }
    @PutMapping("deposit/{id}")
    public ResponseEntity<AccountDto> depostIntoAccount(@PathVariable Long id,
                                                        @RequestBody Map<String  , Double > request){
        AccountDto result=addCoountService.deposit(id,request.get("amount"));
        return   ResponseEntity.ok(result);


    }
    @PutMapping("withdraw/{id}")
    public ResponseEntity<AccountDto> withDraw(@PathVariable Long id, @RequestBody Map<String, Double> request){
        AccountDto result=addCoountService.withDraw(id, request.get("withdraw"));
        return ResponseEntity.ok(result);

    }

    @GetMapping("getAllAccounts")
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
       List<AccountDto> result=addCoountService.getAllAccounts();
       return ResponseEntity.ok(result);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){

       addCoountService.deleteById(id);
       return ResponseEntity.ok("deteted successfully");
    }


}
