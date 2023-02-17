package com.ironhack.finalProject.model.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.finalProject.model.accounts.Account;
import jakarta.persistence.*;
;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AccountHolder extends User{
    private LocalDate birthDate;
    @ManyToOne(cascade= CascadeType.MERGE)
    @JoinColumn(name = "address")
    private Address address;
    @ManyToOne
    @JoinColumn(name = "mailing_address_id")
    private Address mailingAddress;



//    @JsonIgnore
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "primaryOwner")
//    private List<Account> primaryOwner = new ArrayList<>();
//    @JsonIgnore
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "secondaryOwner")
//    private List<Account> secondaryOwner = new ArrayList<>();



    public AccountHolder() {
    }

    public AccountHolder(String name, String authPass, LocalDate birthDate, Address address, Address mailingAddress) {
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
