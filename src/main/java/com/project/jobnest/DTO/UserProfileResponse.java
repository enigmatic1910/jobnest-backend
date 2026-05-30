package com.project.jobnest.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileResponse {
    private Long id;
    private Long userId;
    private String description;
    private Long experienceYrs;
    private String address;
    private String resumeUrl;
    private String linkedinUrl;
    private String imageUrl;
    private String certiUrl;
    private List<String> skills;


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
