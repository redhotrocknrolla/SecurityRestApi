package com.example.securityboot.Service;


import com.example.securityboot.models.User;
import com.example.securityboot.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {


    private final UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl (UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email);
    }

    @Override
    public void createUser(User user) {
        if ((userRepository.findByName(user.getName()) == null) || (userRepository.findByEmail(user.getEmail()) == null)) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);

        }
    }

    @Override
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void updateUser(User user) {
        if ((userRepository.findByName(user.getName()) == null) || (userRepository.findByEmail(user.getEmail()) == null)
        || userRepository.findByLastName(user.getLastName()) == null)
            userRepository.findByAge(user.getAge()); {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);

        }
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
