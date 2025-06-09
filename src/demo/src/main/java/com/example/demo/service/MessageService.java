package com.example.demo.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import com.example.demo.model.Message;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private final Map<UUID, List<Message>> messagesByReceiver = new ConcurrentHashMap<>();

    public Message sendMessage(Message message) {
        message.setId(UUID.randomUUID());
        message.setTimestamp(Instant.now());

        messagesByReceiver.computeIfAbsent(message.getReceiverID(), k -> new ArrayList<>()).add(message);
        return message;
    }
    public List<Message> getInbox(UUID receiverId) {
        return messagesByReceiver.getOrDefault(receiverId, Collections.emptyList());
    }
}
