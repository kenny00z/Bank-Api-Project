package com.ironhack.finalProject.model.accounts;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    @OneToOne
    @JoinColumn(name = "origin_id")
    private Account origin;

    @OneToOne
    @JoinColumn(name = "destination_id")
    private Account destination;

    private final LocalDate time = LocalDate.now();

    public Transfer(){

    }

    public Transfer(BigDecimal amount, Account origin, Account destination){
        this.amount = amount;
        this.origin = origin;
        this.destination = destination;
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

    public Account getOrigin() {
        return origin;
    }

    public void setOrigin(Account origin) {
        this.origin = origin;
    }

    public Account getDestination() {
        return destination;
    }

    public void setDestination(Account destination) {
        this.destination = destination;
    }

    public LocalDate getTime() {
        return time;
    }
}
