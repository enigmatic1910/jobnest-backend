package com.project.jobnest.Repo;

import com.project.jobnest.Entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserProfileRepo extends JpaRepository<UserProfile, Long> {

    Optional<UserProfile> findByUsername(String username);
}
