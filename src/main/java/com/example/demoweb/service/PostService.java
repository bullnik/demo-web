package com.example.demoweb.service;

import com.example.demoweb.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {

    private final List<Post> posts;

    public PostService() {
        posts = new ArrayList<>();
        posts.add(new Post(0L, "first", new Date()));
        posts.add(new Post(1L, "second", new Date()));
        posts.add(new Post(2L, "third", new Date()));
    }

    public List<Post> listAllPosts() {
        return posts;
    }

    public void create(String text) {
        Long newId = Integer.toUnsignedLong(posts.size());
        posts.add(new Post(newId, text, new Date()));
    }

}
