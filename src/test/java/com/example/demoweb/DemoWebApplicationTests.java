package com.example.demoweb;

import com.example.demoweb.controller.LikesController;
import com.example.demoweb.controller.PostsCreateController;
import com.example.demoweb.model.Post;
import com.example.demoweb.repository.PostRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class DemoWebApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	PostsCreateController postsCreateController;

	@Autowired
	PostRepository postRepository;

	@Test
	void controllerExists() throws Exception {
		assertThat(postsCreateController).isNotNull();
	}

	@Test
	void createPost() throws Exception {
		postRepository.deleteAll();

		this.mockMvc.perform(get("/new"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Добавить новый пост")));

		this.mockMvc.perform(post("/new"))
				.andDo(print())
				.andExpect(status().is3xxRedirection());

		Iterable<Post> posts = postRepository.findAll();
		int postCount = 0;
		for (Post ignored : posts) {
			postCount++;
		}
		Assertions.assertTrue(postCount > 0);

	}

	@Test
	void listPosts() throws Exception {
		postRepository.deleteAll();
		postRepository.save(new Post(null, "a", new Date()));

		this.mockMvc.perform(get("/"))
				.andDo(print())
				.andExpect(status().is2xxSuccessful())
				.andExpect(content().string(containsString("<div id=\"posts\" class=\"row article\">")))
				.andExpect(content().string(containsString("Пост от")));
	}
}
