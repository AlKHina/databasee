package com.example.demo;

import java.util.Scanner;
import java.util.UUID;

import com.example.demo.model.Company;
import com.example.mongoapp.Mongo;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class Main {
     public static void main(String[] args) {
        MongoCollection<Company> companies = Mongo.getDatabase().getCollection("companies", Company.class);
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n Введите команду: добавить, список, изменить, удалить, выход");
                String command = scanner.nextLine().trim().toLowerCase();

                switch (command) {
                    case "добавить" -> {
                        System.out.print("Название компании: ");
                        String название = scanner.nextLine();
                        System.out.print("Логин: ");
                        String логин = scanner.nextLine();

                        if (companies.find(Filters.eq("login", логин)).first() != null) {
                            System.out.println("Логин уже используется.");
                            break;
                        }

                        Company newCompany = new Company();
                        newCompany.setId(UUID.randomUUID());
                        newCompany.setName(название);
                        newCompany.setLogin(логин);
                        companies.insertOne(newCompany);
                        System.out.println("Компания добавлена.");
                    }

                    case "список" -> {
                        System.out.println("\n Список компаний:");
                        for (Company c : companies.find()) {
                            System.out.println("- " + c.getName() + " (логин: " + c.getLogin() + ")");
                        }
                    }

                    case "изменить" -> {
                        System.out.print("Введите логин компании для изменения: ");
                        String логинИзменить = scanner.nextLine();

                        Company существующая = companies.find(Filters.eq("login", логинИзменить)).first();
                        if (существующая == null) {
                            System.out.println("Компания не найдена.");
                            break;
                        }

                        System.out.print("Введите новое имя: ");
                        String новоеИмя = scanner.nextLine();
                        companies.updateOne(Filters.eq("login", логинИзменить), Updates.set("name", новоеИмя));
                        System.out.println("Название обновлено.");
                    }

                    case "удалить" -> {
                        System.out.print("Введите логин компании для удаления: ");
                        String логинУдалить = scanner.nextLine();
                        companies.deleteOne(Filters.eq("login", логинУдалить));
                        System.out.println("Компания удалена (если существовала).");
                    }

                    case "выход" -> {
                        System.out.println("Завершение работы.");
                        return;
                    }

                    default -> System.out.println("Неизвестная команда. Доступно: добавить, список, изменить, удалить, выход");
                }
            }
        }
    }
}