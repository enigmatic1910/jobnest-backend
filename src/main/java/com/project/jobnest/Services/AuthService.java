package com.project.jobnest.Services;

import com.project.jobnest.DTO.AuthResponseDto;
import com.project.jobnest.DTO.LoginRequestDto;
import com.project.jobnest.DTO.RegisterRequest;

public interface AuthService {
    void Register(RegisterRequest request);
    AuthResponseDto Login(LoginRequestDto request);
}
