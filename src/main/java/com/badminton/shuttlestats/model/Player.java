package com.badminton.shuttlestats.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.Type;
import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;

import java.util.UUID;

@Entity
public class Player {

    @Id
    @GeneratedValue
    @JdbcType(VarcharJdbcType.class)
    @Column(updatable = false)
    private UUID id;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "main_hand", nullable = false)
    private String mainHand;

    public Player() {}

    public Player(String firstName, String lastName, String gender, String mainHand) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.mainHand = mainHand;
    }

    public UUID getPlayerId() {
        return id;
    }

    public void setPlayerId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMainHand() {
        return mainHand;
    }

    public void setMainHand(String mainHand) {
        this.mainHand = mainHand;
    }
}
