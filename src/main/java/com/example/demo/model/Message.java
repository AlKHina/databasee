package com.example.demo.model;

import java.time.Instant;
import java.util.UUID;

public class Message {
    private UUID id;
    private String content;
    private UUID senderID;
    private UUID receiverID;
    private Instant timestamp;
    private String status;

    public Message() {
         this.id = UUID.randomUUID();
        this.timestamp = Instant.now();
    }

    public Message(String content, UUID id, UUID receiverID, UUID senderID, String status, Instant timestamp) {
        this.content = content;
        this.id = id;
        this.receiverID = receiverID;
        this.senderID = senderID;
        this.status = status;
        this.timestamp = timestamp;
    }



    public UUID getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public UUID getSenderID() {
        return senderID;
    }

    public UUID getReceiverID() {
        return receiverID;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public String getStatus() {
        return status;
    }



    public void setId(UUID id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSenderID(UUID senderID) {
        this.senderID = senderID;
    }

    public void setReceiverID(UUID receiverID) {
        this.receiverID = receiverID;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}