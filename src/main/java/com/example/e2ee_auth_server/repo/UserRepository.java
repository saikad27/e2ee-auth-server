package com.example.e2ee_auth_server.repo;

import com.example.e2ee_auth_server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User,String> {
    public UserDetails findUserByUsername(String username);
}
