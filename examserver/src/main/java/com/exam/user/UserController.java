package com.exam.user;

import com.exam.auth.RegistrationRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
@Log4j2
@CrossOrigin("*")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> register(@RequestBody @Valid RegistrationRequest request){
        log.info("Registering user with request: {}", request);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.register(request));
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getUser(@PathVariable("username") String username){
        log.info("Fetching user with username:{}", username);
        return ResponseEntity.ok(this.userService.getUser(username));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> delete(@PathVariable("userId") Long userId){
        log.info("Deleting user with id: {}", userId);
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();

    }
}
