package com.devcommunity.app.service;

import com.devcommunity.app.dto.DeveloperDTO;
import com.devcommunity.app.dto.LoginResponseDTO;
import com.devcommunity.app.dto.UserDTO;
import com.devcommunity.app.entity.User;
import com.devcommunity.app.exception.ItemAlreadyExistException;
import com.devcommunity.app.exception.ItemNotFoundException;
import com.devcommunity.app.repository.DeveloperRepository;
import com.devcommunity.app.repository.UserRepository;
import com.devcommunity.app.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private DeveloperRepository developerRepository;

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        if(userRepository.existsByEmail(userDTO.getEmail()))
            throw new ItemAlreadyExistException("Email already Registerd.");
        User user = userDTO.toObject();
        user.setId(null);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return UserDTO.toDTO(user);
    }

    @Override
    public LoginResponseDTO signIn(String email, String password) {
        authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            email,
                            password
                    )
            );

        User user = userRepository.findUserByEmail(email).orElseThrow(ItemNotFoundException::new);
        DeveloperDTO developerDTO = DeveloperDTO.toDTO(developerRepository.findByUser(user).orElseThrow());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());
        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
        loginResponseDTO.setToken(jwtUtil.generateToken(userDetails));
        loginResponseDTO.setUser(user);
        loginResponseDTO.setDeveloper(developerDTO);
        return loginResponseDTO;
    }

    @Override
    public String signOut() {
//        return authenticationManager.authenticate().setAuthenticated(false);
        return "Sign out successfull";
    }
}
