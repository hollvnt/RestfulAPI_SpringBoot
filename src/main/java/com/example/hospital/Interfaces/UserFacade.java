package com.example.hospital.Interfaces;


import com.example.hospital.DTO.UserDTO;
import com.example.hospital.Entity.User;
import jakarta.servlet.http.HttpServletRequest;

public interface UserFacade {
    boolean isValidUser(String username, String password);
    UserDTO saveUser(UserDTO userDTO);
    String getAuthenticatedUsername(HttpServletRequest request);
    String getAuthenticatedPassword(HttpServletRequest request);
}
