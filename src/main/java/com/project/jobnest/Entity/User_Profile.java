package com.project.jobnest.Entity;

import jakarta.persistence.*;


import java.time.LocalDateTime;
import java.util.List;

@Entity
public class User_Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long user_id;
    private String headline;
    private String address;
    private int experience_yrs;

    private List<String> skills;
    private String resume_url;
    private String linkedin_url;
    private String portfolio_url;
    private String certi_url;

    private LocalDateTime  created_at;
    private LocalDateTime updated_at;

}
