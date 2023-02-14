package com.ironhack.finalProject.model.users;

import jakarta.persistence.Entity;

@Entity
public class Admin extends User{
    public Admin() {
    }

    public Admin(String name, String authPass) {
        super(name, authPass);
    }
}
