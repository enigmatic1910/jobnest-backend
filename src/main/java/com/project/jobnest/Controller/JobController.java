package com.project.jobnest.Controller;

import com.project.jobnest.DTO.ExternalJobResponseDto;
import com.project.jobnest.DTO.JobRequestDto;
import com.project.jobnest.DTO.JobResponseDto;
import com.project.jobnest.Entity.Job;
import com.project.jobnest.Services.JobService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/jobs")
public class JobController {

    private final JobService jobService;

    @GetMapping
    ResponseEntity<Page<JobResponseDto>> getAllJobs(Pageable pageable){
        return ResponseEntity.ok(jobService.fetchJobs(pageable));
    }

    @GetMapping("/{id}")
    ResponseEntity<JobResponseDto> getJobById(@PathVariable Long id){
        return ResponseEntity.ok(jobService.getJobById(id));
    }

    @PostMapping
    ResponseEntity<JobResponseDto> createJob(@Valid @RequestBody JobRequestDto job){
        return ResponseEntity.ok(jobService.createJob(job));
    }

    ResponseEntity<Job> deleteJob(@PathVariable Long id){
        jobService.deleteJob(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/external")
    ResponseEntity<String> getExternalJobs(){
        jobService.fetchExternalJobs();
        return ResponseEntity.ok("Jobs imported successfully");
    }
}
