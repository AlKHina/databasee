package com.example.demo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Message;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.MessageService;

@RestController
@RequestMapping("/messages")

public class MessageController {
     @Autowired
    private MessageService messageService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping
    public Message sendMessage(@RequestHeader("Authorization") String token,
     @RequestBody Message message) {
        UUID senderId = jwtUtil.extractUserId(token.replace("Bearer ", ""));
        message.setSenderID(senderId);
        return messageService.sendMessage(message);
    }

    @GetMapping("/{userId}")
    public List<Message> getInbox(@PathVariable UUID userId) {
        return messageService.getInbox(userId);
    }
}
