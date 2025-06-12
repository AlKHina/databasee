package com.example.demo.model;

public class LoginRequest {

    private String fullname;
    private String password;
    private String companyBIN;

    public LoginRequest() {
    }

    public LoginRequest(String companyBIN, String fullname, String password) {
        this.companyBIN = companyBIN;
        this.fullname = fullname;
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public String getPassword() {
        return password;
    }

    public String getCompanyBIN() {
        return companyBIN;
    }



    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCompanyBIN(String companyBIN) {
        this.companyBIN = companyBIN;
    }
}
