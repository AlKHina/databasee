package com.example;

import java.util.Scanner;
import java.util.UUID;

import org.bson.conversions.Bson;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

public class Main {
    public static void main(String[] args) {
        MongoCollection<Company> companies = Mongo.getDatabase().getCollection("companies", Company.class);
        try (Scanner scanner = new Scanner(System.in)) {
        System.out.print("Введите название компании: ");
        String name = scanner.nextLine();

        System.out.print("Введите логин для этой компании: ");
        String login = scanner.nextLine();

        Bson filter = Filters.eq("login", login);
        if (companies.find(filter).first() != null) {
            System.out.println(" Компания с таким логином уже существует.");
            return;
        }

        Company newCompany = new Company();
        newCompany.setId(UUID.randomUUID());
        newCompany.setName(name);
        newCompany.setLogin(login);

        companies.insertOne(newCompany);
        System.out.println(" Компания успешно добавлена: " + name);
    }
}
}