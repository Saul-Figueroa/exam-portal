package com.exam.auth;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class RegistrationRequest {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String phone;
    private LocalDate dob;
    private String profilePicture;
    private LocalDateTime lastLoginAt;


}
