package com.example.e2ee_auth_server.component;

public class UserDTO {
    public UserDTO(){

    }
    private String username;
    private String password;
    private String email;
    private String aadhaar;

    public UserDTO(String username, String password, String email, String aadhaar) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.aadhaar = aadhaar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public void setAadhaar(String aadhaar) {
        this.aadhaar = aadhaar;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", aadhaar='" + aadhaar + '\'' +
                '}';
    }
}
