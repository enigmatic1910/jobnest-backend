package com.project.jobnest.Services;

import com.project.jobnest.DTO.JobRequestDto;
import com.project.jobnest.DTO.JobResponseDto;
import com.project.jobnest.Entity.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface JobService {

    Page<JobResponseDto> fetchJobs(Pageable pageable);
    JobResponseDto getJobById(Long id);
    JobResponseDto createJob(JobRequestDto job);
    void deleteJob(Long id);
    String fetchExternalJobs();
}
