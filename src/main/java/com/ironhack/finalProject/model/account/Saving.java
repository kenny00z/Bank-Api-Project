package com.ironhack.finalProject.model.account;

import com.ironhack.finalProject.enums.Status;
import com.ironhack.finalProject.model.user.AccountHolders;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity

public class Saving extends Account{
    private BigDecimal minimumBalance;
    private BigDecimal interestRate;
    private LocalDate creationDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Saving() {
    }

    public Saving(BigDecimal balance, int secretKey, AccountHolders primaryOwner, AccountHolders secondaryOwner, BigDecimal penaltyFee, BigDecimal minimumBalance, BigDecimal interestRate, LocalDate creationDate, Status status) {
        super(balance, secretKey, primaryOwner, secondaryOwner, penaltyFee);
        this.minimumBalance = minimumBalance;
        this.interestRate = interestRate;
        this.creationDate = creationDate;
        this.status = status;
    }

    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(BigDecimal minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
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
