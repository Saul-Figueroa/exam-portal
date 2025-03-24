package com.exam.user;

import com.exam.auth.RegistrationRequest;
import com.exam.exceptions.ResourceAlreadyExistsException;
import com.exam.exceptions.ResourceNotFoundException;
import com.exam.role.Role;
import com.exam.role.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

import static com.exam.role.RoleName.USER;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public UserResponse register(RegistrationRequest request) {
        log.info("Attempting to register user");
        if (userRepository.findByEmail(request.getUsername()).isPresent()) {
            throw new ResourceAlreadyExistsException(User.class, request.getUsername());
        }

        //Load the user role
        Role role = roleRepository.findByName(USER.name()).orElseThrow(() -> new ResourceNotFoundException(Role.class, USER.name()));
        log.info("Role:{}",role.getName());
        //Create user
        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .username(request.getUsername())
                .password(request.getPassword())
                .dob(request.getDob())
                .phone(request.getPhone())
                .profilePicture(request.getProfilePicture())
                .roles(Set.of(role))
                .build();

        User savedUser = this.userRepository.save(user);

        return new UserResponse(savedUser);
    }

    @Override
    public UserResponse getUser(String username) {
        return new UserResponse(this.userRepository.findByEmail(username).orElseThrow(() -> new ResourceNotFoundException(User.class, username)));
    }

    @Override
    public void deleteUser(Long id) {
        User user = this.userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(User.class, id));
        this.userRepository.delete(user);
    }
}
