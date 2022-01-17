package com.example.securityboot.controllers;

import com.example.securityboot.Service.RoleService;
import com.example.securityboot.Service.UserService;
import com.example.securityboot.exception.RoleException;
import com.example.securityboot.exception.UserException;
import com.example.securityboot.models.Role;
import com.example.securityboot.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.Set;


@RestController
@RequestMapping("/api")
public class RestApiController {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public RestApiController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("users")
    public ResponseEntity<Iterable<User>> showAll() {
        Iterable<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<User>getById(@PathVariable ("id") Long id) {
       Optional<User> user = userService.getUserById(id);
        if (!user.isPresent())
            throw new UserException("User not found: " + id + "! " +
                    "Enter new value.");
        ResponseEntity responseEntity = new ResponseEntity(user, HttpStatus.OK);
        return responseEntity;
    }
    @PostMapping("/users")
    public  User addNewUser(@RequestBody User newUser) {
       userService.createUser(newUser);
        return newUser;
    }
    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return user;
    }
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id) {
        Optional <User> user = userService.getUserById(id);
        if (!user.isPresent()) {
            throw new UserException("NO USER " + id);
        }
        userService.deleteUserById(id);
        return "User is delete!!";
    }
    @GetMapping("/roles")
    public Set<Role> getRoles() {
        return roleService.getAllRoles();
    }
    @GetMapping("/roles/{id}")
    public ResponseEntity <Role> getRole(@PathVariable Long id) {
        Optional<Role> role = roleService.findById(id);
        if (!role.isPresent()) {
            throw new RoleException("Role with ID = " + id + " does not exist");
        }
        ResponseEntity responseEntity = new ResponseEntity(role, HttpStatus.OK);
        return responseEntity;
    }
}
