package com.ironhack.finalProject.repositories.users;

import com.ironhack.finalProject.model.users.AccountHolders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountHoldersRepository extends JpaRepository<AccountHolders, Long> {
}