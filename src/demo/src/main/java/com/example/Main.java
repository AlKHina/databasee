package com.example;

import com.mongodb.client.MongoCollection;

public class Main {
    public static void main(String[] args) {
        MongoCollection<Company> companies = Mongo.getDatabase().getCollection("companies", Company.class);

        Company newCompany = new Company();
        newCompany.setName("Acme Corp");
        newCompany.setLogin("admin");
        companies.insertOne(newCompany);
        System.out.println("Добавлена компания: " + newCompany.getName());
    }
}
