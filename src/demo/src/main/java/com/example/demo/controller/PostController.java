package com.example.demo.controller;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Post;

@RestController
@RequestMapping("/posts")
public class PostController {
     private final List<Post> posts = new CopyOnWriteArrayList<>();

    @PostMapping
    public String createPost(@RequestBody Post post) {
        post.setTimestamp(Instant.now());
        posts.add(post);
        return "Post created";
    }
     @GetMapping
    public List<Post> getAllPosts() {
        return posts;
}
 @PostMapping("/{index}/like")
    public String likePost(@PathVariable int index, @RequestParam UUID userId) {
        if (index < 0 || index >= posts.size()) return "Post not found";
        posts.get(index).getLikes().add(userId);
        return "Post liked";
    }
}
