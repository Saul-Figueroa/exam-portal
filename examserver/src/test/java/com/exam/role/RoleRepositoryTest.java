package com.exam.role;

import com.exam.exceptions.ResourceAlreadyExistsException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoleRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    void findByName() {
    }

    @Test
    void createUserRole(){
        Role role = new Role();
        role.setName("USER");
        role.setDescription("Regular application user");
        if(roleRepository.findByName(role.getName()).isPresent()){
            throw new ResourceAlreadyExistsException(Role.class, role.getName());
        }

        roleRepository.saveAndFlush(role);

    }

    @Test
    void createAdminRole(){
        Role role = new Role();
        role.setName("ADMIN");
        role.setDescription("Admin application user");

        if(roleRepository.findByName(role.getName()).isPresent()){
            throw new ResourceAlreadyExistsException(Role.class, role.getName());
        }

        roleRepository.saveAndFlush(role);

    }
}