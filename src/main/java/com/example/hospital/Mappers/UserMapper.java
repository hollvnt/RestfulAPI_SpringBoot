package com.example.hospital.Mappers;

import com.example.hospital.DTO.UserDTO;
import com.example.hospital.Entity.User;

public class UserMapper {
    public User mapDtoToEntity(UserDTO userDTO){
        return User.builder()
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .build();
    }

    public UserDTO mapEntityToDto(User user){
        return UserDTO.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }
}
