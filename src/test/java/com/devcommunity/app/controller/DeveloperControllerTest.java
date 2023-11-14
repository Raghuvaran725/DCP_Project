package com.devcommunity.app.controller;

import com.devcommunity.app.dto.DeveloperDTO;
import com.devcommunity.app.service.DeveloperService;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DeveloperControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    DeveloperService developerService;
    Gson gson = new Gson();
    @Test
    void addDeveloper() throws Exception {
        DeveloperDTO req = new DeveloperDTO(null,"John Doe","java", null,null,null,null,null);
        DeveloperDTO res = new DeveloperDTO(1,"John Doe","java", LocalDate.now(),0,"ACTIVE",null,null);

        when(developerService.addDeveloper(req)).thenReturn(res);
        this.mockMvc.perform(post("/api/developer/addDeveloper")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(req))
        ).andExpect(status().isCreated());
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