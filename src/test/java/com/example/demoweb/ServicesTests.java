package com.example.demoweb;

import com.example.demoweb.model.Post;
import com.example.demoweb.repository.PostRepository;
import com.example.demoweb.service.LikesService;
import com.example.demoweb.service.PostService;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServicesTests {

    @Autowired
    PostService postService;

    @Autowired
    LikesService likesService;

    @MockBean
    PostRepository postRepository;

    @Test
    void createPost() {
        String text = "jija";
        Post post = postService.create("jija");

        Mockito.verify(postRepository, Mockito.times(1)).save(post);
    }

    void likePost() {
        likesService.like(0L);

        Mockito.verify(postRepository, Mockito.times(1)).findById(0L);
    }
}
