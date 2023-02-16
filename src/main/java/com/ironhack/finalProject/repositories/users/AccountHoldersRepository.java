package com.ironhack.finalProject.repositories.users;

import com.ironhack.finalProject.model.users.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountHoldersRepository extends JpaRepository<AccountHolder, Long> {
}