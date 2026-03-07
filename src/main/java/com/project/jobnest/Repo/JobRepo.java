package com.project.jobnest.Repo;

import com.project.jobnest.Entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<Job, Long> {
    boolean existsByTitleAndCompany(String title, String company);
    List<Job> findByTitleIgnoreCase(String title);
}
