package com.ironhack.finalProject.model.users;

import jakarta.persistence.Entity;

@Entity
public class ThirdParty extends User{


    private String hashKey;
    public ThirdParty() {
    }


    public ThirdParty(String name, String authPass, String hashKey) {
        super(name, authPass);
        this.hashKey = hashKey;
    }

}
