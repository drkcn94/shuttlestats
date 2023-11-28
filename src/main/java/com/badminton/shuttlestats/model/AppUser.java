package com.badminton.shuttlestats.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;

import java.util.UUID;

@Entity
public class AppUser {

    @Id
    @GeneratedValue
    @JdbcType(VarcharJdbcType.class)
    @Column(updatable = false)
    private UUID id;
    @Column(unique = true, name = "username", updatable = false)
    private String username;

    @Column(name = "password")
    private String password;

    public AppUser() {}

    public AppUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
