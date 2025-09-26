package com.gestao.financas.controller;

import com.gestao.financas.Entity.User;
import com.gestao.financas.dto.LoginDTO;
import com.gestao.financas.service.PasswordService;
import com.gestao.financas.service.UserService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordService passwordService;

    @Autowired
    private AuthenticationManager authManager;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody @Valid User user) {
        return ResponseEntity.ok(userService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginDTO dto) {
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
        return ResponseEntity.ok("Login efetuado com sucesso para: " + auth.getName());
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestParam String email) {
        passwordService.createPasswordResetToken(email); // ✅ chamada na instância
        return ResponseEntity.ok("Email de redefinição enviado");
    }

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestParam String token,
            @RequestParam String newPassword) {
        passwordService.resetPassword(token, newPassword); // ✅ chamada na instância
        return ResponseEntity.ok("Senha redefinida com sucesso");
    }
}
