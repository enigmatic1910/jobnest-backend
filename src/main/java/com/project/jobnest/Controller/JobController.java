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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/jobs")
public class JobController {

    private final JobService jobService;

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping
    ResponseEntity<Page<JobResponseDto>> getAllJobs(Pageable pageable){
        return ResponseEntity.ok(jobService.fetchJobs(pageable));
    }

    @GetMapping("/{id}")
    ResponseEntity<JobResponseDto> getJobById(@PathVariable Long id){
        return ResponseEntity.ok(jobService.getJobById(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    ResponseEntity<JobResponseDto> createJob(@Valid @RequestBody JobRequestDto job){
        return ResponseEntity.ok(jobService.createJob(job));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    ResponseEntity<Job> deleteJob(@PathVariable Long id){
        jobService.deleteJob(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/external")
    ResponseEntity<String> getExternalJobs(){
        jobService.fetchExternalJobs();
        return ResponseEntity.ok("Jobs imported successfully");
    }

    @GetMapping("/search")
    ResponseEntity<List<JobResponseDto>> searchJobs(@RequestParam String title){
        return ResponseEntity.ok(jobService.searchJobs(title));
    }
}
