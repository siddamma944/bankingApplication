package com.example.bankingApplication.repo;

import com.example.bankingApplication.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountsRepo extends JpaRepository<Account,Long> {
}
