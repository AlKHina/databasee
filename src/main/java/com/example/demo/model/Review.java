package com.example.demo.model;

import java.util.Date;
import java.util.UUID;

public class Review {

    private UUID id;
    private String companyBIN;    
    private UUID authorId;        
    private String content;
    private int rating;           
    private Date createdAt;

    public Review() {
    }

    public Review(UUID authorId, String companyBIN, String content, Date createdAt, UUID id, int rating) {
        this.authorId = authorId;
        this.companyBIN = companyBIN;
        this.content = content;
        this.createdAt = createdAt;
        this.id = id;
        this.rating = rating;
    }

    public UUID getId() {
        return id;
    }

    public String getCompanyBIN() {
        return companyBIN;
    }

    public UUID getAuthorId() {
        return authorId;
    }

    public String getContent() {
        return content;
    }

    public int getRating() {
        return rating;
    }

    public Date getCreatedAt() {
        return createdAt;
    }



    public void setId(UUID id) {
        this.id = id;
    }

    public void setCompanyBIN(String companyBIN) {
        this.companyBIN = companyBIN;
    }

    public void setAuthorId(UUID authorId) {
        this.authorId = authorId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
