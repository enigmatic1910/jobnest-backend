package com.project.jobnest.Repo;

import com.project.jobnest.Entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepo extends JpaRepository<Job, Long> {
    boolean existsByTitleAndCompany(String title, String company);
}
