package com.manuel.curso.springboot.app.springboot_crud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.manuel.curso.springboot.app.springboot_crud.repositories.UserRepository;



@Service
public class JpaUserDetailsService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> userOptional = userRepository.findByUsername(username);

        if(!userOptional.isPresent(){
            throw new UsernameNotFoundException(String.format("Username %s no existe en el sistema", username ));
        })

        User user = userOptional.orElseThrow();

        List<GrantedAuthority> authorities = user.getRoles()
        .stream()
        .map(role -> new SimpleGrantedAuthority(role.getName()))
        .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(
            user.getUsername(),
            user.getPassword(),
            user.isEnabled(),
            accountNonExpired:true,
            credentialsNonExpired: true,
            accountNonLocked: true,
            authorities
        );
        
    }
    
}
