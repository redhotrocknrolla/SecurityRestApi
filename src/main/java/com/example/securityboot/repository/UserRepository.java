package com.example.securityboot.repository;

import com.example.securityboot.models.Role;
import com.example.securityboot.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;


public interface UserRepository extends CrudRepository<User, Long> {

    User findByName(String name);
    User findByEmail(String email);
    User findByLastName(String lastname);
    User findByAge(Integer age);



}
