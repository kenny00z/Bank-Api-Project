package com.ironhack.finalProject.model.accounts;

import com.ironhack.finalProject.enums.Status;
import com.ironhack.finalProject.model.users.AccountHolder;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

@Entity

public class Savings extends Account{
    @DecimalMin(value = "100", inclusive = true)
    @DecimalMax(value = "1000", inclusive = true)
    private BigDecimal minimumBalance;
    @DecimalMax(value = "0.5", inclusive = true)
    private BigDecimal interestRate;
    private final LocalDate creationDate = LocalDate.now();

    @Enumerated(EnumType.STRING)
    private Status status;

    public Savings() {
    }

    public Savings(int secretKey, AccountHolder primaryOwner, AccountHolder secondaryOwner, Status status) {
        super(secretKey, primaryOwner, secondaryOwner);
        this.minimumBalance =  new BigDecimal(1000);
        this.interestRate = new BigDecimal(0.0025).setScale(4, RoundingMode.HALF_EVEN);
        this.status = status;
    }


    public Savings(Long primaryOwnerId, Long secondaryOwnerId, Status status) {
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
    public LocalDate getCreationDate() {
        return creationDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
