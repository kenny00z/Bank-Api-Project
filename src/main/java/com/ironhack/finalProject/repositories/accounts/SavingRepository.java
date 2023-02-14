package com.ironhack.finalProject.repositories.accounts;

import com.ironhack.finalProject.model.accounts.Savings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingRepository extends JpaRepository<Savings, Long> {
}