package com.ironhack.finalProject.model.account;

import com.ironhack.finalProject.model.user.AccountHolders;
import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class CreditCar extends Account{
    private BigDecimal creditLimit;
    private BigDecimal interestRate;

    public CreditCar() {
    }

    public CreditCar(BigDecimal balance, int secretKey, AccountHolders primaryOwner, AccountHolders secondaryOwner, BigDecimal penaltyFee, BigDecimal creditLimit, BigDecimal interestRate) {
        super(balance, secretKey, primaryOwner, secondaryOwner, penaltyFee);
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }
}
