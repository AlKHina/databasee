package com.example.demo.controller;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Company;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

@RestController
@RequestMapping("/companies")
public class CompanyController {
   @Autowired
    private MongoDatabase database;

    @PostMapping
    public String createCompany(@RequestBody Company company) {
        MongoCollection<Document> companies = database.getCollection("companies");

        Document existing = companies.find(eq("login", company.getLogin())).first();
        if (existing != null) {
            return "Компания с таким логином уже существует.";
        }

        Document doc = new Document("login", company.getLogin())
                .append("name", company.getName());

        companies.insertOne(doc);
        return "Компания успешно создана.";
    }

    @PutMapping("/{login}")
    public String updateCompany(@PathVariable String login, @RequestBody Company company) {
        MongoCollection<Document> companies = database.getCollection("companies");

        Document updateDoc = new Document("login", company.getLogin())
                .append("name", company.getName());

        UpdateResult result = companies.updateOne(eq("login", login), new Document("$set", updateDoc));
        return result.getModifiedCount() > 0 ? "Компания обновлена." : "Компания не найдена.";
    }

    @DeleteMapping("/{login}")
    public String deleteCompany(@PathVariable String login) {
        MongoCollection<Document> companies = database.getCollection("companies");

        DeleteResult result = companies.deleteOne(eq("login", login));
        return result.getDeletedCount() > 0 ? "Компания удалена." : "Компания не найдена.";
    }
}