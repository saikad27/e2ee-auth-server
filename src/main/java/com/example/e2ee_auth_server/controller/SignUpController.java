package com.example.e2ee_auth_server.controller;

import com.example.e2ee_auth_server.component.UserDTO;
import com.example.e2ee_auth_server.exception.UserAlreadyExistsException;
import com.example.e2ee_auth_server.service.CustomUserDetailsService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
public class SignUpController {

    private final CustomUserDetailsService userDetailsService;



    public SignUpController(CustomUserDetailsService userDetailsService){
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/signup")
    public void signup(@RequestBody UserDTO userDTO) throws UserAlreadyExistsException {
        userDetailsService.saveUser(userDTO);

    }
    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }
}
