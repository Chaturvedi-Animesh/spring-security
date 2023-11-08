package com.example.springsecurity.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springsecurity.Entity.User;
import com.example.springsecurity.Service.UserService;

@RestController
@RequestMapping("/home")
@PreAuthorize("hasRole('SUPER')")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody User user) {
        if (service.isPresent(user.getUsername())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username Already Exists");
        } else {
            return ResponseEntity.ok(service.addUser(user));
        }
    }

    @GetMapping
    public List<User> getAllUser() {
        return service.getAllUsers();
    }



}
