package com.devcommunity.app.dto;

import com.devcommunity.app.entity.User;
import com.devcommunity.app.util.UserRoleEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO{
	private Integer id;
	private String name;
	private String email;
	private String password;
	private UserRoleEnum role;

	@JsonIgnore
	public static UserDTO toDTO(User user){
		return new UserDTO(user.getId(), user.getName(), user.getEmail(),null, user.getRole());
	}

	@JsonIgnore
	public User toObject(){
		return new User(id,name,email,password,role);
	}
	
}
