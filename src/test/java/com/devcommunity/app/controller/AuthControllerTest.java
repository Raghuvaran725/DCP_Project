package com.devcommunity.app.controller;

import com.devcommunity.app.dto.DeveloperDTO;
import com.devcommunity.app.dto.LoginRequestDTO;
import com.devcommunity.app.dto.LoginResponseDTO;
import com.devcommunity.app.dto.UserDTO;
import com.devcommunity.app.entity.User;
import com.devcommunity.app.service.DeveloperService;
import com.devcommunity.app.service.UserService;
import com.devcommunity.app.util.UserRoleEnum;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class AuthControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;
    @MockBean
    DeveloperService developerService;
    Gson gson = new Gson();

    @Test
    void registerUser() throws Exception {
        var user = new UserDTO(1,"user","user@gmail.com","123", UserRoleEnum.ADMIN);
        DeveloperDTO developerDTO = new DeveloperDTO(1,"satish","java", LocalDate.now(),3,"ac",null,user);
        when(developerService.addDeveloper(developerDTO)).thenReturn(developerDTO);
        when(userService.registerUser(user)).thenReturn(user);
        this.mockMvc.perform(post("/api/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(developerDTO))
                ).andExpect(status().isBadRequest());
    }

    @Test
    void login() throws Exception {
        var lr = new LoginResponseDTO("someRangomToken", new User(1,"user","user@gmail.com","123", UserRoleEnum.ADMIN),null);
        var rl = new LoginRequestDTO("user@gmail.com","123");
        when(userService.signIn("user@gmail.com","123")).thenReturn(lr);

        this.mockMvc.perform(post("/api/auth/login").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(rl))).andDo(print()).andExpect(status().isOk());
    }
}