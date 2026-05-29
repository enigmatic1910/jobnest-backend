package com.project.jobnest.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "companies")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 255)
    private String company_name;

    private String website;
    private String industry;
    private String logoUrl;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    LocalDateTime created_at;
    @UpdateTimestamp
    @Column(nullable = false, updatable = false)
    LocalDateTime updated_at;


}
