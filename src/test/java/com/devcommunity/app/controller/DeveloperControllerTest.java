package com.devcommunity.app.controller;

import com.devcommunity.app.service.DeveloperService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
class DeveloperControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    DeveloperService developerService;
    @Test
    void addDeveloper() {
    }

    @Test
    void updateDeveloper() {
    }

    @Test
    void getDeveloperByStatus() {
    }

    @Test
    void getDeveloperById() {
    }

    @Test
    void getDeveloperByReputation() {
    }

    @Test
    void getAllDevelopers() {
    }

    @Test
    void getPostsByDeveloper() {
    }

    @Test
    void getByMaxReputation() {
    }
}