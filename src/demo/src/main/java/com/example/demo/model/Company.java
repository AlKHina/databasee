package com.example.demo.model;

import java.util.UUID;

public class Company {
     private UUID id;
     private String name;
     private String login;
     private String password;
     private String bin; 
     private String logoUrl; 

    public Company() {
    }

    public Company(String bin, UUID id, String login, String logoUrl, String name, String password) {
        this.bin = bin;
        this.id = id;
        this.login = login;
        this.logoUrl = logoUrl;
        this.name = name;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getBin() {
        return bin;
    }

    public String getLogoUrl() {
        return logoUrl;
    }



    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}  