package com.ironhack.finalProject.model.accounts;

import com.ironhack.finalProject.enums.Status;
import com.ironhack.finalProject.model.users.AccountHolder;
import com.ironhack.finalProject.model.utils.Money;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity

public class StudentChecking extends Account{

    private LocalDate creationDate;
    @Enumerated(EnumType.STRING)
    private Status status;

    public StudentChecking() {
    }

    public StudentChecking(Money balance, int secretKey, AccountHolder primaryOwner, AccountHolder secondaryOwner, BigDecimal penaltyFee, LocalDate creationDate, Status status) {
        super(balance, secretKey, primaryOwner, secondaryOwner, penaltyFee);
        this.creationDate = creationDate;
        this.status = status;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
