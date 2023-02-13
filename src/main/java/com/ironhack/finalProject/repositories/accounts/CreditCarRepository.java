package com.ironhack.finalProject.repositories.accounts;

import com.ironhack.finalProject.model.accounts.CreditCar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCarRepository extends JpaRepository<CreditCar, Long> {
}