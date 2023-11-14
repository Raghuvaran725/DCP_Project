package com.devcommunity.app.controller;

import com.devcommunity.app.dto.PostDTO;
import com.devcommunity.app.service.PostService;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
class PostControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PostService postService;

    Gson gson = new Gson();
    @BeforeEach
    void setUp() {
    }

    @Test
    void addPost() throws Exception {
        PostDTO req = new PostDTO(null, "Nextjs",null,"Nextjs 14 is on fire",null,null,null,null,null);
        PostDTO res = new PostDTO(1, "Nextjs", LocalDateTime.now(),"Nextjs 14 is on fire",null,null,null,0,null);
        when(postService.addPost(req)).thenReturn(res);
        this.mockMvc.perform(post("/api/post/addPost")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(req))
        ).andExpect(status().isCreated());
    }

    @Test
    void addVote() {
    }

    @Test
    void updatePost() {
    }

    @Test
    void getNoOfVotesOnPostByVoteType() {
    }

    @Test
    void getPostById() {
    }

    @Test
    void removePost() {
    }

    @Test
    void getPostsByKeyword() {
    }

    @Test
    void getPostsByDeveloperId() {
    }

    @Test
    void getPostsByTopic() {
    }

    @Test
    void getPostsByDate() {
    }

    @Test
    void getAllPosts() {
    }
}