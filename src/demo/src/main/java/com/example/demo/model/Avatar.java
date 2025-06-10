package com.example.demo.model;

public class Avatar {

    private String fullname;
    private String companyBIN;
    private String avatarUrl;
    
    public Avatar() {
    }

    public Avatar(String fullname, String companyBIN, String avatarUrl) {
        this.fullname = fullname;
        this.companyBIN = companyBIN;
        this.avatarUrl = avatarUrl;
    }

    public String getFullname() {
        return fullname;
    }

    public String getCompanyBIN() {
        return companyBIN;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }



    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setCompanyBIN(String companyBIN) {
        this.companyBIN = companyBIN;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
