package com.example.oauth2test.service;

import com.example.oauth2test.pojo.Role;
import com.example.oauth2test.pojo.User;
import com.example.oauth2test.repository.RoleRepository;
import com.example.oauth2test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        List<Role> roleList = roleRepository.findRolesByUserId(user.getId());
        user.setRoleList(roleList);
        return user;
    }
}
