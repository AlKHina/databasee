package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtUtil;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public AuthService(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    public String login(String username, String password) {
        Document user = userRepository.findByUsername(username);
        if (user != null && user.getString("password").equals(password)) {
            return jwtUtil.generateToken(username);
        }
        return null;
    }

    public void register(User user) {
        userRepository.save(user);
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }
}
