package com.example.hospital.Interfaces;


import com.example.hospital.Entity.User;
import jakarta.servlet.http.HttpServletRequest;

public interface UserService {
    boolean isValidUser(String username, String password);
    User saveUser(User user);
    String getAuthenticatedUsername(HttpServletRequest request);
    String getAuthenticatedPassword(HttpServletRequest request);
}
