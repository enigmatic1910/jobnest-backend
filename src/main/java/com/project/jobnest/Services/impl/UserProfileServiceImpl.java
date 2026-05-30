package com.project.jobnest.Services.impl;

import com.project.jobnest.DTO.UserProfileRequest;
import com.project.jobnest.DTO.UserProfileResponse;
import com.project.jobnest.Entity.User;
import com.project.jobnest.Entity.UserProfile;
import com.project.jobnest.Repo.UserProfileRepo;
import com.project.jobnest.Services.UserProfileService;

public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepo userProfileRepo;

    public UserProfileServiceImpl(UserProfileRepo userProfileRepo) {
        this.userProfileRepo = userProfileRepo;
    }

    @Override
    public UserProfileResponse getMyProfile(String username) {
        UserProfile userProfile = userProfileRepo.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));

        return new UserProfileResponse(
                userProfile.getId(),
                userProfile.getUser().getId(),
                userProfile.getDescription(),
                userProfile.getExperienceYrs(),
                userProfile.getAddress(),
                userProfile.getResumeUrl(),
                userProfile.getLinkedinUrl(),
                userProfile.getImageUrl(),
                userProfile.getCertiUrl(),
                userProfile.getSkills(),
                userProfile.getCreatedAt(),
                userProfile.getUpdatedAt()
                );
    }

    @Override
    public UserProfileResponse updateMyProfile(String username, UserProfileRequest userProfileRequest) {
        return null;
    }

    @Override
    public void createDefaultProfile(User user) {

    }
}
