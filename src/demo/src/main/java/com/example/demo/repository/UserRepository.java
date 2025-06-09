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

    public Document findByUsername(String username) {
        return collection.find(new Document("username", username)).first();
    }

    public void save(User user) {
        Document doc = new Document("name", user.getFullname())
                .append("password", user.getPassword());
        collection.insertOne(doc);
    }
}