package com.example.demo.controller;

import org.bson.Document;
import org.bson.types.Binary;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
public class AvatarController {

    private final UserRepository userRepository;

    public AvatarController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/avatar")
    public ResponseEntity<byte[]> getAvatar(
            @RequestParam String fullname,
            @RequestParam String companyBIN) {

        Document user = userRepository.findByFullnameAndCompanyBIN(fullname, companyBIN);
        if (user == null || !user.containsKey("avatarData")) {
            return ResponseEntity.notFound().build();
        }

        byte[] avatar = user.get("avatarData", Binary.class).getData();

        return ResponseEntity
                .ok()
                .header("Content-Type", "image/png")
                .body(avatar);
    }
}

