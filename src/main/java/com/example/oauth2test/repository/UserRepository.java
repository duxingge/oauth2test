package com.example.oauth2test.repository;

import com.example.oauth2test.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    public User findByUsername(String name);
}
