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
public class Checking extends Account{
    private final BigDecimal minimumBalance = new BigDecimal(250);
    private BigDecimal monthlyMaintenanceFee;

    private final LocalDate creationDate = LocalDate.now();
    @Enumerated(EnumType.STRING)
    private Status status;

    public Checking() {
    }

    public Checking(int secretKey, AccountHolder primaryOwner, AccountHolder secondaryOwner, Status status) {
        super(secretKey, primaryOwner, secondaryOwner);
        this.monthlyMaintenanceFee =  new BigDecimal(12);
        this.status = status;
    }

    public Checking(AccountHolder primaryOwner, AccountHolder secondaryOwner, int secretKey) {
        super(secretKey, primaryOwner, secondaryOwner);
    }


    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }

    public BigDecimal getMonthlyMaintenanceFee() {
        return monthlyMaintenanceFee;
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
