package com.example;

import java.util.UUID;

public class User {
    private UUID id;
    private UUID companyID;
    private String fullname;
    private String position;
    private String email;
    private String password;

    public User() {
        this.id = UUID.randomUUID();
    }

    public User(UUID companyID, String email, String fullname, UUID id, String password, String position) {
        this.companyID = companyID;
        this.email = email;
        this.fullname = fullname;
        this.id = id;
        this.password = password;
        this.position = position;
    }



    public UUID getId() {
        return id;
    }

    public UUID getCompanyID() {
        return companyID;
    }

    public String getFullname() {
        return fullname;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }



    public void setId(UUID id) {
        this.id = id;
    }

    public void setCompanyID(UUID companyID) {
        this.companyID = companyID;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}