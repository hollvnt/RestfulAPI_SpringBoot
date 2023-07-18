package com.example.hospital.Facade.impl;

import com.example.hospital.DTO.UserDTO;
import com.example.hospital.Entity.User;
import com.example.hospital.Facade.UserFacade;
import com.example.hospital.Mappers.UserMapper;
import com.example.hospital.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserFacadeImpl implements UserFacade {
    private final UserService userService;
    private final UserMapper userMapper;

    @Override
    public boolean isValidUser(String username, String password) {
        return userService.isValidUser(username, password);
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        User user = userMapper.mapDtoToEntity(userDTO);
        user = userService.saveUser(user);
        return userMapper.mapEntityToDto(user);
    }

    @Override
    public String getAuthenticatedUsername(HttpServletRequest request) {
        return userService.getAuthenticatedUsername(request);
    }

    @Override
    public String getAuthenticatedPassword(HttpServletRequest request) {
        return userService.getAuthenticatedPassword(request);
    }
}
