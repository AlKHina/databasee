package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.RegisterRequest;
import com.example.demo.model.User;

@Service
public class UserService {

    private final Map<UUID, User> users = new HashMap<>();

    public ResponseEntity<?> register(RegisterRequest request) {
        UUID userId = UUID.randomUUID();
        User user = new User();
        user.setId(userId);
        user.setFullname(request.getFullname());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setPosition(request.getPosition());
        user.setCompanyBIN(request.getCompanyBIN());
        user.setAvatarUrl(request.getAvatarUrl());

        users.put(userId, user);

        return ResponseEntity.ok("User registered successfully!");
    }

    public User createUser(User user) {
        users.put(user.getId(), user);
        return user;
    }

    public User getUser(UUID id) {
        return users.get(id);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public boolean updateUser(UUID id, User updatedUser) {
        if (users.containsKey(id)) {
            User existingUser = users.get(id);
            existingUser.setCompanyID(updatedUser.getCompanyID());
            existingUser.setFullname(updatedUser.getFullname());
            existingUser.setPosition(updatedUser.getPosition());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPassword(updatedUser.getPassword());
            return true;
        }
        return false;
    }

    public boolean deleteUser(UUID id) {
        return users.remove(id) != null;
    }
}
