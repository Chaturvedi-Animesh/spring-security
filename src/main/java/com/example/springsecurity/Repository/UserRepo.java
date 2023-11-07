package com.example.springsecurity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springsecurity.Entity.User;

public interface UserRepo extends JpaRepository<User,Long>{

    User findByUsername(String username);
    
}
