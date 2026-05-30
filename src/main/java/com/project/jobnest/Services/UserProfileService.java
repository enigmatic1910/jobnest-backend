package com.project.jobnest.Services;

import com.project.jobnest.DTO.UserProfileRequest;
import com.project.jobnest.DTO.UserProfileResponse;
import com.project.jobnest.Entity.User;
import com.project.jobnest.Entity.UserProfile;

public interface UserProfileService {

    UserProfileResponse getMyProfile(String username);
    UserProfileResponse updateMyProfile(String username, UserProfileRequest userProfileRequest);
    void createDefaultProfile(User user);
}
