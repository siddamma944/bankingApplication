package com.example.bankingApplication.exception;

public class AccountException extends RuntimeException{
    public AccountException(String message){
        super(message);
    }
}
