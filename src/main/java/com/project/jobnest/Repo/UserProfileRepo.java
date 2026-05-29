package com.project.jobnest.Repo;

import com.project.jobnest.Entity.User_Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepo extends JpaRepository<User_Profile, Long> {
}
