package com.ironhack.finalProject.controller.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class AccountDTO {

    private Long primaryOwnerId;
    private Long secondaryOwnerId;
    private BigDecimal minimumBalance;
    private BigDecimal monthlyMaintenanceFee;
    private BigDecimal creditLimit;
    private BigDecimal interestRate;

    private int secretKey;




    public AccountDTO(Long primaryOwnerId, Long secondaryOwnerId, BigDecimal minimumBalance, BigDecimal monthlyMaintenanceFee, BigDecimal creditLimit, BigDecimal interestRate, String secretKey) {
        this.primaryOwnerId = primaryOwnerId;
        this.secondaryOwnerId = secondaryOwnerId;
        this.minimumBalance = minimumBalance;
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountDTO that = (AccountDTO) o;
        return Objects.equals(primaryOwnerId, that.primaryOwnerId) && Objects.equals(secondaryOwnerId, that.secondaryOwnerId) && Objects.equals(minimumBalance, that.minimumBalance) && Objects.equals(monthlyMaintenanceFee, that.monthlyMaintenanceFee) && Objects.equals(creditLimit, that.creditLimit) && Objects.equals(interestRate, that.interestRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(primaryOwnerId, secondaryOwnerId, minimumBalance, monthlyMaintenanceFee, creditLimit, interestRate);
    }

    @Override
    public String toString() {
        return "AccountDTO{" +
                "primaryOwnerId=" + primaryOwnerId +
                ", secondaryOwnerId=" + secondaryOwnerId +
                ", minimumBalance=" + minimumBalance +
                ", monthlyMaintenanceFee=" + monthlyMaintenanceFee +
                ", creditLimit=" + creditLimit +
                ", interestRate=" + interestRate +
                '}';
    }

    public Long getPrimaryOwnerId() {
        return primaryOwnerId;
    }

    public void setPrimaryOwnerId(Long primaryOwnerId) {
        this.primaryOwnerId = primaryOwnerId;
    }

    public Long getSecondaryOwnerId() {
        return secondaryOwnerId;
    }

    public void setSecondaryOwnerId(Long secondaryOwnerId) {
        this.secondaryOwnerId = secondaryOwnerId;
    }

    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(BigDecimal minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public BigDecimal getMonthlyMaintenanceFee() {
        return monthlyMaintenanceFee;
    }

    public void setMonthlyMaintenanceFee(BigDecimal monthlyMaintenanceFee) {
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
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

    public int getSecretKey() {
        return secretKey;
    }
}
