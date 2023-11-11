package com.devcommunity.app.service;


import com.devcommunity.app.repository.UserRepository;
import com.devcommunity.app.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findUserByEmail(email);
        if(user.isPresent()) {
            User _user = user.get();
            return  new org.springframework.security.core.userdetails.User(_user.getEmail(), _user.getPassword(), new ArrayList<>());
        }
        return null;
    }
}
