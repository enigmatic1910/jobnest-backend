package com.project.jobnest.Controller;

import com.project.jobnest.DTO.AuthResponseDto;
import com.project.jobnest.DTO.LoginRequestDto;
import com.project.jobnest.DTO.RegisterRequest;
import com.project.jobnest.Services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    ResponseEntity<String> registerUser(@RequestBody RegisterRequest request) {
        System.out.println(request.getUsername());
        System.out.println(request.getEmail());
        System.out.println(request.getPassword());
        authService.Register(request);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    ResponseEntity<AuthResponseDto> login(@RequestBody LoginRequestDto request){
        return  ResponseEntity.ok(authService.Login(request));
    }
}
