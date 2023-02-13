package com.ironhack.finalProject.repositories.accounts;

import com.ironhack.finalProject.model.accounts.Checking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckingRepository extends JpaRepository<Checking, Long> {
}