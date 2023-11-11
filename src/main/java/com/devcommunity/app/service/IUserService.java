package com.devcommunity.app.service;

import com.devcommunity.app.dto.LoginResponseDTO;
import com.devcommunity.app.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
	UserDTO registerUser(UserDTO user);

	LoginResponseDTO signIn(String userName, String password);

	// use session management accordingly
	public String signOut();
}
