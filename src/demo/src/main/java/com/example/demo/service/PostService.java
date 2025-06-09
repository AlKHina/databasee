package com.example.demo.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.example.demo.model.Post;

@Service
public class PostService {
     private final Map<UUID, List<Post>> postsByUser = new ConcurrentHashMap<>();

    public Post createPost(UUID userId, Post post) {
        post.setSenderID(userId);
        post.setTimestamp(Instant.now());

        postsByUser.computeIfAbsent(userId, k -> new ArrayList<>()).add(post);
        return post;
    }
     public List<Post> getPosts(UUID userId) {
        return postsByUser.getOrDefault(userId, Collections.emptyList());
    }
}
