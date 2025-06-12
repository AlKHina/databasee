package com.example.demo.controller;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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

import jakarta.validation.Valid;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private MongoDatabase database;

    @PostMapping
    public ResponseEntity<String> createCompany(@Valid @RequestBody Company company) {
        MongoCollection<Document> companies = database.getCollection("companies");

        if (companies.find(eq("login", company.getLogin())).first() != null) {
            return ResponseEntity.badRequest().body("Компания с таким логином уже существует.");
        }

        Document doc = new Document("login", company.getLogin())
                .append("name", company.getName());
        companies.insertOne(doc);

        return ResponseEntity.ok("Компания успешно создана.");
    }

    @GetMapping
    public List<Company> getCompanies() {
        MongoCollection<Document> companies = database.getCollection("companies");
        return companies.find()
                .map(doc -> {
                    Company c = new Company();
                    c.setLogin(doc.getString("login"));
                    c.setName(doc.getString("name"));
                    return c;
                })
                .into(new java.util.ArrayList<>());
    }

    @PutMapping("/{login}")
    public ResponseEntity<String> updateCompany(@PathVariable String login, @RequestBody Company company) {
        MongoCollection<Document> companies = database.getCollection("companies");

        Document updateDoc = new Document("login", company.getLogin())
                .append("name", company.getName());

        UpdateResult result = companies.updateOne(eq("login", login), new Document("$set", updateDoc));
        return result.getModifiedCount() > 0
                ? ResponseEntity.ok("Компания обновлена.")
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{login}")
    public ResponseEntity<String> deleteCompany(@PathVariable String login) {
        MongoCollection<Document> companies = database.getCollection("companies");

        DeleteResult result = companies.deleteOne(eq("login", login));
        return result.getDeletedCount() > 0
                ? ResponseEntity.ok("Компания удалена.")
                : ResponseEntity.notFound().build();
    }
}
