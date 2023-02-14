package com.ironhack.finalProject.model.users;

import jakarta.persistence.*;

@Embeddable
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "address")
    private String address;
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "city")
    private String city;

    public Address() {
    }

    public Address(String address, String postalCode, String city) {
        this.setAddress(address);
        this.setPostalCode(postalCode);
        this.setCity(city);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
