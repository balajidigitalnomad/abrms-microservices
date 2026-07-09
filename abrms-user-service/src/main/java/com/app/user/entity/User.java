package com.app.user.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name="app_user")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long userId;

    @NotBlank(message = "First name required.")
    @Size(max=50, message="First name should not exceeds 50 characters.")
    @Column(name="first_name", nullable = false)
    private String firstName;

    @Size(max=50, message = "Second name should not exceeds 50 characters.")
    @Column(name="last_name")
    private String lastName;

    @NotBlank(message ="Email id required.")
    @Size(max=100,message = "Email id should not exceeds 100 characters.")
    @Column(name="email_id", nullable = false)
    private String emailId;

    @NotBlank(message = "Password required")
    @Column(name="password",nullable = false)
    private String password;

    @Column(name="is_active")
    private Boolean isActive;


}
