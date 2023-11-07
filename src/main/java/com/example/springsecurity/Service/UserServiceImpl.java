package com.example.springsecurity.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.springsecurity.Entity.User;
import com.example.springsecurity.Repository.UserRepo;

@Service 
public class UserServiceImpl implements UserService,UserDetailsService{

    @Autowired
    private UserRepo repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) {
        System.out.println("Query for user "+username);
        User user = repo.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("No User found with the given username");
        }

        return org.springframework.security.core.userdetails.User.builder()
        .username(user.getUsername())
        .password(user.getPassword())
        .build();
    }

    @Override
    public User addUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));

        return repo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public boolean isPresent(String username){
        User user = repo.findByUsername(username);
        if(user == null) return false;
        return true;
    }

    
    
}
