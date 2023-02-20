package com.ironhack.finalProject.controller.dto;

import java.math.BigDecimal;


public class TransferDTO {

    private Long id;
    private BigDecimal amount;
    private Long issuingAccountId;
    private Long receivingAccountId;

    public TransferDTO() {
    }

    public TransferDTO(BigDecimal amount, Long issuingAccountId, Long receivingAccountId) {
        this.amount = amount;
        this.issuingAccountId = issuingAccountId;
        this.receivingAccountId = receivingAccountId;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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
}
