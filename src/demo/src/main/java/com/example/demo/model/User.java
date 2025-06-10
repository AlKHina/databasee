package com.example.demo.model;
import java.util.UUID;

public class User {
    private UUID id;
    private UUID companyID;
    private String fullname;
    private String position;
    private String email;
    private String password;
     private String companyBIN; 
    private String avatarUrl;

    public User() {
    }

    public User(String avatarUrl, String companyBIN, UUID companyID, String email, String fullname, UUID id, String password, String position) {
        this.avatarUrl = avatarUrl;
        this.companyBIN = companyBIN;
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

    public String getCompanyBIN() {
        return companyBIN;
    }

    public String getAvatarUrl() {
        return avatarUrl;
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

    public void setCompanyBIN(String companyBIN) {
        this.companyBIN = companyBIN;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}