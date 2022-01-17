package com.example.securityboot.Service;

import com.example.securityboot.models.Role;

import java.util.Optional;
import java.util.Set;



public interface RoleService {
    void createRoles(Set<Role> roles);
    Set<Role> getAllRoles();
    Optional<Role> findById(Long id);


}
