package com.uniovi.sdi2223206spring.entities;

import javax.persistence.*;
import java.util.Set;

//Colección que no admite duplicados
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true)
    private String email;

    private String name;

    private String lastName;

    private String role;

    private String password;

    private double wallet;

    @Transient
    //propiedad que no se almacena en la tabla.
    private String passwordConfirm;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Offer> offers;
    @OneToMany(mappedBy = "userBuyer", cascade = CascadeType.ALL)
    private Set<Offer> buyedOffers;

    public User(String email, String name, String lastName) {
        super();
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.wallet = 100;
    }

    public User() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }

    public String getFullName() {
        return this.name + " " + this.lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Set<Offer> getBuyedOffers() {
        return buyedOffers;
    }

    public void setBuyedOffers(Set<Offer> buyedOffers) {
        this.buyedOffers = buyedOffers;
    }
}