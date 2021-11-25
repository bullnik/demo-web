package com.example.demoweb;

import com.example.demoweb.model.Post;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostTests {

    @Test
    void testPost() throws Exception {
        Date date = new Date();
        long id = 42343;
        String text = "jijoba";

        Post post = new Post(id, text, date);

        Assertions.assertEquals(post.getText(), text);
        Assertions.assertEquals(post.getCreationDate(), date);
        Assertions.assertEquals(post.getLikes(), 0);
    }

}
