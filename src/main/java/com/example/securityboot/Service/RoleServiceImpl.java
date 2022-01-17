package com.example.securityboot.Service;

import org.springframework.stereotype.Service;
import com.example.securityboot.models.Role;
import com.example.securityboot.repository.RoleRepository;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl (RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void createRoles(Set<Role> roles) {
        roleRepository.saveAll(roles);
    }

    @Override
    public Set<Role> getAllRoles() {
        Iterable<Role>  iterable = roleRepository.findAll();
        Set<Role> set = new HashSet<>();
        iterable.forEach(set::add);
        return set;
    }

    @Override
    public Optional<Role> findById(Long id) {
        return roleRepository.findById(id);
    }

}
