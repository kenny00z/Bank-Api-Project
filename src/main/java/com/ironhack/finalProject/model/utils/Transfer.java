package com.ironhack.finalProject.model.utils;

import com.ironhack.finalProject.model.accounts.Account;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long issuingAccountId;
    private Long receivingAccountId;
    private BigDecimal amount;
    private LocalDate date;
    @ManyToOne
    Account account;

    public Transfer() {
    }

    public Transfer(Long issuingAccountId, Long receivingAccountId, BigDecimal amount, LocalDate date, Account account) {
        this.issuingAccountId = issuingAccountId;
        this.receivingAccountId = receivingAccountId;
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIssuingAccountId() {
        return issuingAccountId;
    }

    public void setIssuingAccountId(Long issuingAccountId) {
        this.issuingAccountId = issuingAccountId;
    }

    public Long getReceivingAccountId() {
        return receivingAccountId;
    }

    public void setReceivingAccountId(Long receivingAccountId) {
        this.receivingAccountId = receivingAccountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
