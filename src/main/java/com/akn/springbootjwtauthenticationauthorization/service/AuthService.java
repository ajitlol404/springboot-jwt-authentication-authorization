package com.akn.springbootjwtauthenticationauthorization.service;

import com.akn.springbootjwtauthenticationauthorization.dto.JwtResponse;
import com.akn.springbootjwtauthenticationauthorization.dto.LoginRequest;
import com.akn.springbootjwtauthenticationauthorization.dto.RegisterRequest;
import com.akn.springbootjwtauthenticationauthorization.dto.UserResponse;
import com.akn.springbootjwtauthenticationauthorization.entity.User;
import com.akn.springbootjwtauthenticationauthorization.repository.UserRepository;
import com.akn.springbootjwtauthenticationauthorization.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public UserResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();
        User savedUser = userRepository.save(user);
        return UserResponse.builder()
                .id(savedUser.getId())
                .firstname(savedUser.getFirstname())
                .lastname(savedUser.getLastname())
                .email(savedUser.getEmail())
                .role(savedUser.getRole())
                .build();
    }

    public JwtResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(new UserDetailsImpl(user));
        return JwtResponse.builder()
                .token(jwtToken)
                .build();
    }
}