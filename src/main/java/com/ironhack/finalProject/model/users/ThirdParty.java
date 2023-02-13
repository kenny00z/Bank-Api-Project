package com.ironhack.finalProject.model.users;

import jakarta.persistence.Entity;

@Entity
public class ThirdParty extends User{
    public ThirdParty() {
    }

    public ThirdParty(String name, String authPass) {
        super(name, authPass);
    }
}
