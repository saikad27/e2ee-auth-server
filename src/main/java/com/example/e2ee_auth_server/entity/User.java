package com.example.e2ee_auth_server.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name="users")
public class User implements UserDetails {

    public User(String userId,String username,String password,List<GrantedAuthority> roles,String email,String aadhaar){
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.email = email;
        this.aadhaar = aadhaar;
    }

    @Id
    private String userId;
    private String username;
    private String password;
    private List<GrantedAuthority> roles;
    private String email;

    @Column(unique=true)
    private final String aadhaar;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void setRoles(List<GrantedAuthority> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAadhaar() {
        return aadhaar;
    }


}
