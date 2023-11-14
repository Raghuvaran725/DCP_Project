package com.devcommunity.app.controller;

import com.devcommunity.app.dto.AddCommentDTO;
import com.devcommunity.app.dto.CommentDTO;
import com.devcommunity.app.entity.Comment;
import com.devcommunity.app.service.CommentService;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CommentControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    CommentService commentService;

    Gson gson = new Gson();
    @BeforeEach
    void setUp() {
    }

    @Test
    void addComment() throws Exception {
        AddCommentDTO addCommentDTO = new AddCommentDTO("Some comment",1,1,null,true);
        Comment comment = new Comment(1,addCommentDTO.getComment(),null, LocalDate.now(),null,null,null);
        when(commentService.create(addCommentDTO)).thenReturn(comment);
        this.mockMvc.perform(post("/api/comment/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(addCommentDTO))
        ).andExpect(status().isCreated());
    }

    @Test
    void testAddComment() {
    }

    @Test
    void updateComment() {
    }

    @Test
    void removeComment() {
    }

    @Test
    void getNoOfVotesOnCommentByVoteType() {
    }

    @Test
    void getByCommentId() {
    }

    @Test
    void getCommentsByResponseId() {
    }

    @Test
    void getCommentsByPostId() {
    }
}