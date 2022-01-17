package com.example.securityboot.Service;

import com.example.securityboot.models.User;

import java.util.Optional;

public interface UserService {
    void createUser(User user);
    Iterable<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(User user);
    Optional<User> getUserById(Long id);
    void deleteUserById (Long id);
}
