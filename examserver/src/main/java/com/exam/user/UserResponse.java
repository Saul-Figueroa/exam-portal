package com.exam.user;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
public class UserResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private Set<String> roles = new HashSet<>();
    private String profilePicture;
    private LocalDate dob;
    private LocalDateTime lastLoginAt;

    public UserResponse(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.username = user.getUsername();
        this.profilePicture = user.getProfilePicture();
        this.dob = user.getDob();
        this.lastLoginAt = user.getLastLoginAt();
        user.getRoles().forEach(role -> this.roles.add(role.getName()));


    }
}
