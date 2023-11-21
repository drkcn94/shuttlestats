package com.badminton.shuttlestats.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Player {

    @Id
    @Column(name = "id")
    private UUID playerId;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "main_hand")
    private String mainHand;

    public Player() {}

    public Player(String name, String gender, String mainHand) {
        this.playerId = UUID.randomUUID();
        this.name = name;
        this.gender = gender;
        this.mainHand = mainHand;
    }

    public UUID getPlayerId() {
        return playerId;
    }

    public void setPlayerId(UUID playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
