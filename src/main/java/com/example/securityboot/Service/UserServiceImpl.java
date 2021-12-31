package com.example.securityboot.Service;


import com.example.securityboot.models.User;
import com.example.securityboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {


    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }
    @Override
    public List<User> getAllUser() {
        return userRepository.getAllUser();
    }

    @Override
    public User getUserById(long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public void createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.createUser(user);

    }

    @Override
    public void updateUser(long id, User updatedUser) {
        if (updatedUser.getPassword() != "")
            updatedUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
        userRepository.updateUser(id, updatedUser);
    }
    @Override
    public void deleteUser(long id) {
        userRepository.deleteUser(id);
    }
}
