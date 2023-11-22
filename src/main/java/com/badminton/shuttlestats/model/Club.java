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

    @Column(name = "description")
    private String clubDescription;

    public Club() {}

    public Club(String clubName, Boolean publicVisibility, String clubDescription) {
        this.clubId = UUID.randomUUID();
        this.clubName = clubName;
        this.creationDate = LocalDate.now();
        this.publicVisibility = publicVisibility;
        this.clubDescription = clubDescription;
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

    public String getClubDescription() {
        return clubDescription;
    }

    public void setClubDescription(String clubDescription) {
        this.clubDescription = clubDescription;
    }
}
