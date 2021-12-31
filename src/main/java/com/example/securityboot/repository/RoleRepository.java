package com.example.securityboot.repository;

import com.example.securityboot.models.Role;
import java.util.HashSet;
import java.util.List;

public interface RoleRepository {

    List <Role> getAllRoles();
    Role getRoleByName(String name);
    HashSet<Role> getSetOfRoles(String[] roleNames);

}
