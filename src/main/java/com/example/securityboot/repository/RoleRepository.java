package com.example.securityboot.repository;

import com.example.securityboot.models.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface RoleRepository extends CrudRepository<Role, Long> {
    @Override
    Optional<Role> findById(Long id);
}
