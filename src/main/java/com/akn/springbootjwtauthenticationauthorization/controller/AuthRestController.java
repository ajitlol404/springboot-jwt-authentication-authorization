package com.akn.springbootjwtauthenticationauthorization.controller;

import com.akn.springbootjwtauthenticationauthorization.dto.JwtResponse;
import com.akn.springbootjwtauthenticationauthorization.dto.LoginRequest;
import com.akn.springbootjwtauthenticationauthorization.dto.RegisterRequest;
import com.akn.springbootjwtauthenticationauthorization.dto.UserResponse;
import com.akn.springbootjwtauthenticationauthorization.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
        @RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthRestController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

}
