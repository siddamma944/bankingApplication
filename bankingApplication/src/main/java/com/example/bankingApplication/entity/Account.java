package com.example.bankingApplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="accounts")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountHolderName;
    private double balance;

}
