package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.RegisterRequest;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/register")
public class RegisterController {

    @PostMapping
    public String registerUser(@Valid @RequestBody RegisterRequest request) {
        System.out.println("Регистрация пользователя:");
        System.out.println("ФИО: " + request.getFullname());
        System.out.println("Email: " + request.getEmail());
        System.out.println("БИН: " + request.getPseudoBin());

        return "Пользователь зарегистрирован (тестовый вывод)";
    }
}
