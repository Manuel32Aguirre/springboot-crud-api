package com.manuel.curso.springboot.app.springboot_crud.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manuel.curso.springboot.app.springboot_crud.entities.Role;
import com.manuel.curso.springboot.app.springboot_crud.entities.User;
import com.manuel.curso.springboot.app.springboot_crud.repositories.RoleRepository;
import com.manuel.curso.springboot.app.springboot_crud.repositories.UserRepository;
import com.manuel.curso.springboot.app.springboot_crud.services.UserService;



@Service

public class UserServiceImpl implements UserService{
    
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        return (List<User>)userRepository.findAll();
    }

    @Override
    @Transactional
    public User save(User user) {
        
        Optional<Role> optionalRoleUser = roleRepository.findByName("ROLE_USER");
        List<Role> roles = new ArrayList<>();
        if(optionalRoleUser.isPresent()){
            roles.add(optionalRoleUser.get());
        }
        if(user.isAdmin() == true){
            Optional<Role> optionalRoleAdmin = roleRepository.findByName("ROLE_ADMIN");
            if(optionalRoleAdmin.isPresent()){
                roles.add(optionalRoleAdmin.get());
            }
        }

        user.setRoles(roles);
        String passwordEncoded = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordEncoded);

        return userRepository.save(user);
    }
    
}
