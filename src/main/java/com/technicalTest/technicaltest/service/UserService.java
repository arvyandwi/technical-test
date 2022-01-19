package com.technicalTest.technicaltest.service;

import com.technicalTest.technicaltest.entity.Role;
import com.technicalTest.technicaltest.entity.User;
import com.technicalTest.technicaltest.response.RegisterResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Set;

public interface UserService extends UserDetailsService {
    RegisterResponse create(User user, Set<Role> roles);
}
