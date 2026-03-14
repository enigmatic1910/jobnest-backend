package com.project.jobnest.Services.impl;

import com.project.jobnest.DTO.AuthResponseDto;
import com.project.jobnest.DTO.LoginRequestDto;
import com.project.jobnest.DTO.RegisterRequest;
import com.project.jobnest.Entity.User;
import com.project.jobnest.Repo.UserRepository;
import com.project.jobnest.Services.AuthService;
import com.project.jobnest.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtService jwtService;

    @Override
    public void Register(RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());

        String hashedPassword = bCryptPasswordEncoder.encode(request.getPassword());
        user.setPassword(hashedPassword);

        user.setRole("USER");

        User saved = userRepository.save(user);
        System.out.println("Saved userId: "+saved.getId());
        System.out.println("Saved username: "+saved.getUsername());


    }

    @Override
    public AuthResponseDto Login(LoginRequestDto request) {
        User user = userRepository.findByUsername(request.getUsername()).orElseThrow(() -> new RuntimeException("User not found"));

        if(!bCryptPasswordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Passwords don't match");
        }

        String token = jwtService.generateToken(user);

        return new AuthResponseDto(token);
    }
}
