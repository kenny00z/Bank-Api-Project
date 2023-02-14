package com.ironhack.finalProject.controller.dto;

import com.ironhack.finalProject.model.users.Address;

import java.time.LocalDate;

public class AccountHolderDTO {

    private Long id;
    private String name;
    private LocalDate birthDate;
    private Address address;
    private Address mailingAddress;


}
