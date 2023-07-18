package com.example.hospital.Controller;

import com.example.hospital.DTO.UserDTO;
import com.example.hospital.Facade.UserFacade;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserFacade userFacade;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO){
        try {
            UserDTO newUser = userFacade.saveUser(userDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> loginUser(@RequestBody UserDTO userDTO, HttpServletResponse response) {
        try {
            if (!userFacade.isValidUser(userDTO.getUsername(), userDTO.getPassword())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }

            Cookie loginCookie = new Cookie("login", userDTO.getUsername());
            Cookie passwordCookie = new Cookie("password", userDTO.getPassword());
            loginCookie.setMaxAge(10 * 60);
            passwordCookie.setMaxAge(10 * 60);
            response.addCookie(loginCookie);
            response.addCookie(passwordCookie);

            return ResponseEntity.ok(userDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
