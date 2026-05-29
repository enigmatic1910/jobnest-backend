package com.project.jobnest.Repo;

import com.project.jobnest.Entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<Company, Long> {

}
