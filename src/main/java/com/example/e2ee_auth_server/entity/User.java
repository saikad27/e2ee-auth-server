package com.example.e2ee_auth_server.entity;


import com.example.e2ee_auth_server.component.UserDTO;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Table(name="users")
public class User implements UserDetails {

    public User(){

    }
    public User(UserDTO userDTO){
        this.userId = UUID.randomUUID().toString();
        this.username = userDTO.getUsername();
        this.email = userDTO.getEmail();
        this.password = userDTO.getPassword();
        this.roles = Set.of("ROLE_USER");
        this.aadhaar = userDTO.getAadhaar();
    }
    public User(String userId,String username,String password,List<String> roles,String email,String aadhaar){
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.roles = Set.of("ROLE_USER");;
        this.email = email;
        this.aadhaar = aadhaar;
    }

    @Id
    private String userId;
    private String username;
    private String password;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role", columnDefinition = "VARCHAR(50)")
    private Set<String> roles;
    private String email;

    @Column(unique=true)
    private String aadhaar;

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
        return roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String getAadhaar() {
        return aadhaar;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", email='" + email + '\'' +
                ", aadhaar='" + aadhaar + '\'' +
                '}';
    }
}
