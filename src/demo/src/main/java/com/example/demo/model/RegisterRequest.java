package com.example.demo.model;

import jakarta.validation.constraints.Pattern;

public class RegisterRequest {
 private String fullname;
    private String email;
    private String password;
    private String position;
    private String companyBIN;
    private String avatarUrl;

    @Pattern(regexp = "\\d{12}", message = "Псевдо-БИН должен состоять из 12 цифр")
    private String pseudoBin;
    public RegisterRequest() {
    }

    public RegisterRequest(String avatarUrl, String companyBIN, String email, String fullname, String password, String position, String pseudoBin) {
        this.avatarUrl = avatarUrl;
        this.companyBIN = companyBIN;
        this.email = email;
        this.fullname = fullname;
        this.password = password;
        this.position = position;
        this.pseudoBin = pseudoBin;
    }

    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPosition() {
        return position;
    }

    public String getCompanyBIN() {
        return companyBIN;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getPseudoBin() {
        return pseudoBin;
    }


    
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setCompanyBIN(String companyBIN) {
        this.companyBIN = companyBIN;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public void setPseudoBin(String pseudoBin) {
        this.pseudoBin = pseudoBin;
    }

}