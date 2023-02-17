package com.ironhack.finalProject.model.accounts;

import com.ironhack.finalProject.model.users.AccountHolder;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

@Entity
public class CreditCard extends Account {
    @DecimalMin(value = "100", inclusive = true)
    @DecimalMax(value = "1000", inclusive = true)
    private BigDecimal creditLimit;

    @DecimalMin(value = "0.1", inclusive = true, message = "the value asdasd entre 01-02")
    @DecimalMax(value = "0.2", inclusive = true, message = "the value asdasd entre 01-02")
    private BigDecimal interestRate;


    private LocalDate lastInterestDay;


    public CreditCard() {
    }

    public CreditCard(int secretKey, AccountHolder primaryOwner, AccountHolder secondaryOwner, LocalDate lastInterestDay) {
        super(secretKey, primaryOwner, secondaryOwner);
        this.creditLimit = new BigDecimal(100);
        this.interestRate = new BigDecimal(0.2).setScale(4, RoundingMode.HALF_EVEN);
        this.lastInterestDay = lastInterestDay;
    }

    public CreditCard(BigDecimal creditLimit, BigDecimal interestRate, Long primaryOwnerId, Long secondaryOwnerId) {
    }


    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public LocalDate getLastInterestDay() {
        return lastInterestDay;
    }

    public void setLastInterestDay(LocalDate lastInterestDay) {
        this.lastInterestDay = lastInterestDay;
    }
}
