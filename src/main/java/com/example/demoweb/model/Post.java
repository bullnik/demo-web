package com.example.demoweb.model;

public class Post {
    private String text;
    private int likes;

    public Post(String text) {
        this.text=text;
    }

    public int getLikes() {
        return likes;
    }

    public String getText() {
        return text;
    }
}
