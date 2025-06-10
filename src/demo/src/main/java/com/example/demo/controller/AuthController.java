package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        authService.register(user);
        return "Пользователь зарегистрирован";
    }

    @PostMapping("/login")
public String login(@RequestBody User user) {
    String token = authService.login(
        user.getFullname(),
        user.getPassword(),
        user.getCompanyBIN()
    );
    return token != null ? token : "Неверные данные";
}
}