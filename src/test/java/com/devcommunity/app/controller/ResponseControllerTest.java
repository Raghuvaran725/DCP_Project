package com.devcommunity.app.controller;

import com.devcommunity.app.dto.AddCommentDTO;
import com.devcommunity.app.dto.ResponseDTO;
import com.devcommunity.app.entity.Response;
import com.devcommunity.app.service.ResponseService;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
class ResponseControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ResponseService responseService;
    

 

    @InjectMocks
    private ResponseController responseController; 

    Gson gson = new Gson();
    @BeforeEach
    void setUp() {
    }

   /* @Test
    void addResponse() throws Exception {
        ResponseDTO req = new ResponseDTO(null,"Very good post",null,null,null,null);
        ResponseDTO res = new ResponseDTO(1,"Very good post", LocalDateTime.now(),null,new ArrayList<>(),new ArrayList<>());
        when(responseService.addResponse(req)).thenReturn(res);
        this.mockMvc.perform(post("/api/response/addResponse")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(req))
        ).andExpect(status().isCreated());
    }
    */
    
    


    @Test
    void create() throws Exception {
        AddCommentDTO req = new AddCommentDTO("Response title",1,2,null,false);
        Response res = new Response(1,"Very good post", LocalDateTime.now(),null,null,new ArrayList<>(),new ArrayList<>());
        when(responseService.create(req)).thenReturn(res);
        this.mockMvc.perform(post("/api/response/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(req))
        ).andExpect(status().isCreated());
    }
    
    @Test
    void getNoOfVotesOnResponseByVoteType() throws Exception {
        when(responseService.getNoOfVotesOnResponseByVoteType("UPVOTE",3)).thenReturn(2);
        this.mockMvc.perform(get("/api/response/getNoOfVotesOnResponseByVoteType/3/UPVOTE")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

    @Test
    void updateResponse() {
    }

    @Test
    void removeResponse() {
    }

    @Test
    void getResponseByPost() {
    }

 

    @Test
    void getResponseByDeveloper() {
    }
}