package com.example.demo.repository;

import org.bson.Document;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Repository
public class UserRepository {

    private final MongoCollection<Document> collection;

    public UserRepository(MongoClient mongoClient) {
        MongoDatabase db = mongoClient.getDatabase("testdb");
        this.collection = db.getCollection("users");
    }

    public Document findByFullnameAndCompanyBIN(String fullname, String companyBIN) {
        return collection.find(
            new Document("fullname", fullname)
                .append("companyBIN", companyBIN)
        ).first();
    }

     public void save(User user) {
    Document doc = new Document("id", user.getId().toString())
        .append("companyID", user.getCompanyID().toString())
        .append("fullname", user.getFullname())
        .append("position", user.getPosition())
        .append("email", user.getEmail())
        .append("password", user.getPassword())
        .append("companyBIN", user.getCompanyBIN())
        .append("avatarUrl", user.getAvatarUrl());
    collection.insertOne(doc);
}
}