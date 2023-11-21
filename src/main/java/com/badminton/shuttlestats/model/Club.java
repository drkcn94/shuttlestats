package com.badminton.shuttlestats.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Club {

    @Id
    @Column(name = "id")
    private UUID clubId;

    @Column(name = "name")
    private String clubName;

    @Column(name = "creation_date")
    private LocalDate creationDate;

    @Column(name = "public_visibility")
    private Boolean publicVisibility;

    public Club() {}

    public Club(String clubName, LocalDate creationDate, Boolean publicVisibility) {
        this.clubId = UUID.randomUUID();
        this.clubName = clubName;
        this.creationDate = creationDate;
        this.publicVisibility = publicVisibility;
    }

    public UUID getClubId() {
        return clubId;
    }

    public void setClubId(UUID clubId) {
        this.clubId = clubId;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Boolean getPublicVisibility() {
        return publicVisibility;
    }

    public void setPublicVisibility(Boolean publicVisibility) {
        this.publicVisibility = publicVisibility;
    }
}
