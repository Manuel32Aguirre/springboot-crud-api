package com.manuel.curso.springboot.app.springboot_crud.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.manuel.curso.springboot.app.springboot_crud.entities.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{
    
    @Query("SELECT r from Role r where r.name = ?1")
    Optional<Role> findByName(String name);

}
