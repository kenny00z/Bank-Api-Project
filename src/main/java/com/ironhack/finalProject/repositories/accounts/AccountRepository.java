package com.ironhack.finalProject.repositories.accounts;

import com.ironhack.finalProject.model.accounts.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}