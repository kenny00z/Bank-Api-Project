package com.ironhack.finalProject.repositories.accounts;

import com.ironhack.finalProject.model.accounts.Savings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingRepository extends JpaRepository<Savings, Long> {
}