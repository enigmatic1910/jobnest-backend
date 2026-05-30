package com.project.jobnest.DTO;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileRequest {
    private String description;
    private String address;
    private int experienceYrs;

    private List<String> skills;
    private String resumeUrl;
    private String linkedinUrl;
    private String imageUrl;
    private String certiUrl;
}
