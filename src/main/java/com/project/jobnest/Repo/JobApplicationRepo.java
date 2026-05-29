package com.project.jobnest.Repo;

import com.project.jobnest.Entity.Job_Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobApplicationRepo extends JpaRepository<Job_Application, Long> {
}
