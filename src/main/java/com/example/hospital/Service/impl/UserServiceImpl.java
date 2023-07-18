package com.example.hospital.Service.impl;

import com.example.hospital.Entity.User;
import com.example.hospital.Repository.UserRepository;
import com.example.hospital.Service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public boolean isValidUser(String username, String password) {
        User user = userRepository.findByUsername(username);

        return user != null && user.getPassword().equals(password);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public String getAuthenticatedUsername(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if(cookies != null ){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("login")){
                    return cookie.getValue();
                }
            }
        }
        return  null;
    }

    @Override
    public String getAuthenticatedPassword(HttpServletRequest request) {
        Cookie [] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("password")){
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}
