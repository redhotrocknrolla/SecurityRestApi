package com.example.securityboot.repository;



import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface UserRepository {
    List<User> getAllUser();
    User getUserById(long id);
    void createUser(User user);
    void updateUser(long id, User updatedUser);
    void deleteUser(long id);
    User getUserByName(String name);
}
