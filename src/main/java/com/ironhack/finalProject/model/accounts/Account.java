package com.ironhack.finalProject.model.accounts;

import com.ironhack.finalProject.model.users.AccountHolder;
import com.ironhack.finalProject.model.utils.Money;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private Money balance;

    private int secretKey;

    @ManyToOne
    @JoinColumn(name="primaryOwner_id")
    private AccountHolder primaryOwner;

    @ManyToOne
    @JoinColumn(name="secondaryOwner_id")
    private AccountHolder secondaryOwner;

    private BigDecimal penaltyFee;

    public Account() {
    }

    public Account(Money balance, int secretKey, AccountHolder primaryOwner, AccountHolder secondaryOwner, BigDecimal penaltyFee) {
        this.balance = balance;
        this.secretKey = secretKey;
        this.primaryOwner = primaryOwner;
        this.secondaryOwner = secondaryOwner;
        this.penaltyFee = penaltyFee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public int getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(int secretKey) {
        this.secretKey = secretKey;
    }

    public AccountHolder getPrimaryOwner() {
        return primaryOwner;
    }

    public void setPrimaryOwner(AccountHolder primaryOwner) {
        this.primaryOwner = primaryOwner;
    }

    public AccountHolder getSecondaryOwner() {
        return secondaryOwner;
    }

    public void setSecondaryOwner(AccountHolder secondaryOwner) {
        this.secondaryOwner = secondaryOwner;
    }

    public BigDecimal getPenaltyFee() {
        return penaltyFee;
    }

    public void setPenaltyFee(BigDecimal penaltyFee) {
        this.penaltyFee = penaltyFee;
    }
}
