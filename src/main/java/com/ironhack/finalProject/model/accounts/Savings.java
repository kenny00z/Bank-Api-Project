package com.ironhack.finalProject.model.accounts;

import com.ironhack.finalProject.enums.Status;
import com.ironhack.finalProject.model.users.AccountHolder;
import com.ironhack.finalProject.model.utils.Money;
import jakarta.persistence.Embedded;
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
//    @DecimalMin(value = "100", inclusive = true)
//    @DecimalMax(value = "1000", inclusive = true)
    @Embedded
    private Money minimumBalance;
    @DecimalMax(value = "0.5", inclusive = true)
    private BigDecimal interestRate;
    private final LocalDate creationDate = LocalDate.now();

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDate lastInterestDay;

    public Savings() {
    }

    public Savings(int secretKey, AccountHolder primaryOwner, AccountHolder secondaryOwner, Status status, LocalDate lastInterestDay) {
        super(secretKey, primaryOwner, secondaryOwner);
        this.minimumBalance =  new Money(BigDecimal.valueOf(1000));
        this.interestRate = new BigDecimal(0.0025).setScale(4, RoundingMode.HALF_EVEN);
        this.status = status;
        this.lastInterestDay = lastInterestDay;
    }


    public Savings(Long primaryOwnerId, Long secondaryOwnerId, Status status) {
        this.status= status;
    }


    public Money getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(Money minimumBalance) {
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

    public LocalDate getLastInterestDay() {
        return lastInterestDay;
    }

    public void setLastInterestDay(LocalDate lastInterestDay) {
        this.lastInterestDay = lastInterestDay;
    }
}
