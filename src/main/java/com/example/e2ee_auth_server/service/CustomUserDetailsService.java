package com.example.e2ee_auth_server.service;

import com.example.e2ee_auth_server.component.UserDTO;
import com.example.e2ee_auth_server.entity.User;
import com.example.e2ee_auth_server.exception.UserAlreadyExistsException;
import com.example.e2ee_auth_server.repo.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    public CustomUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Loading user from database : "+username);
        System.out.println(userRepository.findUserByUsername(username));
        return userRepository.findUserByUsername(username);
    }
    public void saveUser(UserDTO userDTO) throws UserAlreadyExistsException {
        userRepository.save(new User(userDTO));
    }
}
