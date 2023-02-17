package com.ironhack.finalProject.repositories.accounts;

import com.ironhack.finalProject.model.accounts.Account;
import com.ironhack.finalProject.model.users.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account getByPrimaryOwner(AccountHolder accountHolder);
}