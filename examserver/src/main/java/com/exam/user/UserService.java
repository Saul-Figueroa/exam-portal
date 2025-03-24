package com.exam.user;

import com.exam.auth.RegistrationRequest;
import com.exam.role.Role;

import java.util.Set;

public interface UserService {

    UserResponse register(RegistrationRequest request);
    UserResponse getUser(String username);
    void deleteUser(Long id);
}
