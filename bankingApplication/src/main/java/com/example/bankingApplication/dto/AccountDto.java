package com.example.bankingApplication.dto;

//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//public class AccountDto {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String accountHolderName;
//    private double balance;
//
//}

//record is used as a DTO class, and introduced in java16 . It transfer data between client and server
//it is immutable
//it reduces boilerplate code
public record AccountDto(Long id,String accountHolderName,double balance){

}
