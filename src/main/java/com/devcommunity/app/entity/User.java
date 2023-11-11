package com.devcommunity.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.devcommunity.app.util.UserRoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity @NoArgsConstructor @AllArgsConstructor @Data
@Table(name="users_table")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    @JsonIgnore
    private String password;
    private UserRoleEnum role;
}
