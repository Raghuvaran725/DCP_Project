package com.devcommunity.app.dto;


import com.devcommunity.app.entity.Developer;
import com.devcommunity.app.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class LoginResponseDTO {
    private String token;
    private User user;
    private DeveloperDTO developer;
}
