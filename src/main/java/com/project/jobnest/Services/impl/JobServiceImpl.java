package com.project.jobnest.Services.impl;

import com.project.jobnest.DTO.JobRequestDto;
import com.project.jobnest.DTO.JobResponseDto;
import com.project.jobnest.Entity.Job;
import com.project.jobnest.Repo.JobRepo;
import com.project.jobnest.Services.JobService;
import com.project.jobnest.exception.JobNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepo jobRepo;

    @Override
    public Page<JobResponseDto> fetchJobs(Pageable pageable) {
        Page<Job> jobs = jobRepo.findAll(pageable);

        return jobs
                .map(job -> new JobResponseDto(
                        job.getId(),
                        job.getTitle(),
                        job.getCompany()
                ));
    }

    @Override
    public JobResponseDto getJobById(Long id) {
        Job jobById = jobRepo.findById(id).orElseThrow(() -> new JobNotFoundException("Job not found" + id));

        return new JobResponseDto(
                jobById.getId(),
                jobById.getTitle(),
                jobById.getCompany()
        );
    }

    @Override
    public JobResponseDto createJob(JobRequestDto dto) {
        Job job = new Job();
        job.setTitle(dto.getTitle());
        job.setCompany(dto.getCompany());

        Job savedJobs = jobRepo.save(job);

        return new JobResponseDto(
                savedJobs.getId(),
                savedJobs.getTitle(),
                savedJobs.getCompany()
        );
    }

    @Override
    public void deleteJob(Long id) {
        if(!jobRepo.existsById(id)){
            throw new JobNotFoundException("Job not Found" + id);
        }
        jobRepo.deleteById(id);
    }

    @Override
    public String fetchExternalJobs() {

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.arbeitnow.com/api/job-board-api";

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        return response.getBody();
    }
}
