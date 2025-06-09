package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.example.demo.model.User;

public class UserService {
    private final Map<UUID, User> users = new HashMap<>();
    public User createUser(User user){
        users.put (user.getId(), user);
        return user;
    }
    public User getUser(UUID id){
        return users.get(id);
    }
    public List<User> getAllUsers(){
        return new ArrayList<>(users.values());
    }
    public boolean updateUser(UUID id, User updatedUser){
        if (users.containsKey(id)){
            User existngUser = users.get(id);
            existngUser.setCompanyID(updatedUser.getCompanyID());
            existngUser.setFullname(updatedUser.getFullname());
            existngUser.setPosition(updatedUser.getPosition());
            existngUser.setEmail(updatedUser.getEmail());
            existngUser.setPassword(updatedUser.getPassword());
            return true;
        }
        return false;
        }
    public boolean deleteUser(UUID id){
        return users.remove(id) != null;
    }
    }

