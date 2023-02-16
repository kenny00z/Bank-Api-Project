package com.ironhack.finalProject.repositories.accounts;

import com.ironhack.finalProject.model.accounts.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
}