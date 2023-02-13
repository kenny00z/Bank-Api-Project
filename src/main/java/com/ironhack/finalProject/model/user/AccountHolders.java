package com.ironhack.finalProject.model.user;

import jakarta.persistence.*;
;

import java.time.LocalDate;

@Entity
public class AccountHolders extends User{
    private LocalDate birthDate;
    @ManyToOne(cascade= CascadeType.MERGE)
    @JoinColumn(name = "address")
    private Address address;
    @ManyToOne
    @JoinColumn(name = "mailing_address_id")
    private Address mailingAddress;

    public AccountHolders() {
    }

    public AccountHolders(String name, String authPass, LocalDate birthDate, Address address, Address mailingAddress) {
        super(name, authPass);
        this.birthDate = birthDate;
        this.address = address;
        this.mailingAddress = mailingAddress;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(Address mailingAddress) {
        this.mailingAddress = mailingAddress;
    }
}
