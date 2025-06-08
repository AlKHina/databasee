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

    }

    public User(UUID companyID, String email, String fullname, UUID id, String password, String position) {
        this.companyID = companyID;
        this.email = email;
        this.fullname = fullname;
        this.id = UUID.randomUUID();
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
    @Override
    public String toString(){
        return "User{" +
                "id=" + id +
                ", companyID=" + companyID +
                ", fullname='" + fullname + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}