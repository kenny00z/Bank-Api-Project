package com.ironhack.finalProject.controller.dto;

import java.math.BigDecimal;

public class BalanceDTO {

    private Long id;

    private BigDecimal balance;


    public BalanceDTO() {
    }

    public BalanceDTO(BigDecimal balance) {
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setAmount(BigDecimal balance) {
        this.balance = balance;
    }
}
