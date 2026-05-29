package com.project.jobnest.Entity;

//import com.project.jobnest.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(unique = true, nullable = false)
    private String email;
    private String phoneNumber;
    private String password;

//    @Enumerated(EnumType.STRING)
    private String role;

    private String about;
    private String profilePictureUrl;

}
