package com.example.demo.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping("/avatar")
    public String uploadAvatar(
            @RequestParam("fullname") String fullname,
            @RequestParam("companyBIN") String companyBIN,
            @RequestParam("file") MultipartFile file) {
        try {
            boolean updated = authService.updateAvatar(fullname, companyBIN, file);
            return updated ? "Аватар обновлён" : "Пользователь не найден";
        } catch (IOException e) {
            return "Ошибка загрузки: " + e.getMessage();
        }
    }
}
