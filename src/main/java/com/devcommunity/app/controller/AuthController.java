package com.devcommunity.app.controller;
import com.devcommunity.app.dto.*;
import com.devcommunity.app.service.DeveloperService;
import com.devcommunity.app.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    UserService userService;
    @Autowired
    DeveloperService developerService;

    @PostMapping("/register")
    public ResponseEntity<BasicDTO<DeveloperDTO>> registerUser(@RequestBody DeveloperDTO developerDTO) {
        DeveloperDTO user = developerService.addDeveloper(developerDTO);
        return new ResponseEntity<>(new BasicDTO<>(true,"User successfully registered",user), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<BasicDTO<LoginResponseDTO>> login(@RequestBody LoginRequestDTO loginRequestDTO){
        return ResponseEntity.ok(new BasicDTO<>(userService.signIn(loginRequestDTO.getEmail(), loginRequestDTO.getPassword())));
    }

}
