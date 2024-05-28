package com.proyecto.carritoCompra.controller;

import com.proyecto.carritoCompra.DTO.LoginRequestDTO;
import com.proyecto.carritoCompra.DTO.SignUpRequestDTO;
import com.proyecto.carritoCompra.exception.UserAlreadyExistsException;
import com.proyecto.carritoCompra.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    public UserController(UserService userService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody SignUpRequestDTO signUpRequest) {
        try {
            userService.createUserAndCustomer(
                    signUpRequest.getUsername(),
                    signUpRequest.getPassword(),
                    signUpRequest.getName(),
                    signUpRequest.getSecondName(),
                    signUpRequest.getLastName(),
                    signUpRequest.getSecondLastName(),
                    signUpRequest.getNumberPhone(),
                    signUpRequest.getEmail(),
                    signUpRequest.getAddress(),
                    signUpRequest.getCountryId(),
                    signUpRequest.getStateId()
            );
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuario creado exitosamente");
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDTO loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );
            return ResponseEntity.ok("Inicio de sesión exitoso");
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario o contraseña incorrectos");
        }
    }
}
