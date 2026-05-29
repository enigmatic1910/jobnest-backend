package com.project.jobnest.Entity;

import com.project.jobnest.enums.ApplicationStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
public class Job_Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false)
    private BigInteger job_id;
    @Column(nullable = false, unique = true)
    private BigInteger candidate_id;
    private int reviewd_by;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;

    @Column(nullable = false)
    private String cover_letter;
    private String resume_url;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime created_at;
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updated_at;
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime applied_at;
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime last_changed_at;

}
