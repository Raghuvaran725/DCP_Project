package com.devcommunity.app.controller;

import com.devcommunity.app.service.CommentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
class CommentControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    CommentService commentService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void addComment() {
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