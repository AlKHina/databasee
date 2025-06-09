package com.example.demo.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Post {
    private String content;
    private String image;
    private UUID senderID;
    private List<UUID> likes = new ArrayList<>();
    private String comments;
    private Instant timestamp;

    public Post() {
         this.timestamp = Instant.now();
    }

    public Post(String comments, String content, String image, UUID senderID, Instant timestamp) {
        this.comments = comments;
        this.content = content;
        this.image = image;
        this.senderID = senderID;
        this.timestamp = timestamp;
    }



    public String getContent() {
        return content;
    }

    public String getImage() {
        return image;
    }

    public UUID getSenderID() {
        return senderID;
    }

    public List<UUID> getLikes() {
        return likes;
    }

    public String getComments() {
        return comments;
    }

    public Instant getTimestamp() {
        return timestamp;
    }



    public void setContent(String content) {
        this.content = content;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setSenderID(UUID senderID) {
        this.senderID = senderID;
    }

    public void setLikes(List<UUID> likes) {
        this.likes = likes;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }
}
