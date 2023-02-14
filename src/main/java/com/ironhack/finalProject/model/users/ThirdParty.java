package com.ironhack.finalProject.model.users;

import jakarta.persistence.*;

@Entity
public class ThirdParty {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String hashKey;


    public ThirdParty( String hashKey) {

        this.hashKey = hashKey;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ThirdParty() {
    }



}
