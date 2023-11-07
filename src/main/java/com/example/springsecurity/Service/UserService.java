package com.example.springsecurity.Service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import com.example.springsecurity.Entity.User;


public interface UserService {

public UserDetails loadUserByUsername(String username);

public User addUser(String username, String password);

public List<User> getAllUsers();
public boolean isPresent(String username);

}
