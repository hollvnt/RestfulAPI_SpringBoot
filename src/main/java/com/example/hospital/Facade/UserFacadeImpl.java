package com.example.hospital.Facade;

import com.example.hospital.DTO.PatientDTO;
import com.example.hospital.DTO.UserDTO;
import com.example.hospital.Entity.Patient;
import com.example.hospital.Entity.User;
import com.example.hospital.Interfaces.UserFacade;
import com.example.hospital.Interfaces.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserFacadeImpl implements UserFacade {
    private final UserService userService;

    @Override
    public boolean isValidUser(String username, String password) {
        return userService.isValidUser(username, password);
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        User user = mapDtoToEntity(userDTO);
        user = userService.saveUser(user);
        return mapEntityToDto(user);
    }

    @Override
    public String getAuthenticatedUsername(HttpServletRequest request) {
        return userService.getAuthenticatedUsername(request);
    }

    @Override
    public String getAuthenticatedPassword(HttpServletRequest request) {
        return userService.getAuthenticatedPassword(request);
    }

    private User mapDtoToEntity(UserDTO userDTO){
        return User.builder()
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .build();
    }

    private UserDTO mapEntityToDto(User user){
        return UserDTO.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }
}
