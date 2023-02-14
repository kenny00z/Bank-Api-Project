package com.ironhack.finalProject.model.accounts;

import com.ironhack.finalProject.model.users.AccountHolder;
import com.ironhack.finalProject.model.utils.Money;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
public class CreditCar extends Account{
    @DecimalMin(value = "100", inclusive = true)
    @DecimalMax(value = "1000", inclusive = true)
    private BigDecimal creditLimit = new BigDecimal(100);

    @DecimalMin(value = "0.1", inclusive = true)
    @DecimalMax(value = "0.2", inclusive = true)
    private BigDecimal interestRate = new BigDecimal(0.2).setScale(4,RoundingMode.HALF_EVEN);

    public CreditCar() {
    }

    public CreditCar(Money balance, int secretKey, AccountHolder primaryOwner, AccountHolder secondaryOwner, BigDecimal penaltyFee, BigDecimal creditLimit, BigDecimal interestRate) {
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
