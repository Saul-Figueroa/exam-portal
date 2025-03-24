package com.exam.role;

import lombok.Getter;

@Getter
public enum RoleName {
    USER("USER"),
    ADMIN("ADMIN");

    // Getter method to access the name
    private final String name; // Add 'final' since it should be immutable

    // Constructor
    RoleName(String name) {
        this.name = name;
    }

}
