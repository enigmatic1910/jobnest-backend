package com.project.jobnest.Entity;

import com.project.jobnest.enums.EmploymentType;
import com.project.jobnest.enums.JobStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "jobs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private int company_id;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String company;
    private String description;
    private String location;

    private Long salary;

    @Enumerated(EnumType.STRING)
    private EmploymentType  employmentType;
    @Enumerated(EnumType.STRING)
    private JobStatus status;

    @CreationTimestamp
    LocalDateTime created_at;
    @UpdateTimestamp
    LocalDateTime updated_at;
    @CreationTimestamp
    LocalDateTime closed_at;
}
