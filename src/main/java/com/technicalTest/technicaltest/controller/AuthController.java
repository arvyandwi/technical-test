package com.technicalTest.technicaltest.controller;

import com.technicalTest.technicaltest.entity.Role;
import com.technicalTest.technicaltest.entity.User;
import com.technicalTest.technicaltest.request.RegisterRequest;
import com.technicalTest.technicaltest.response.RegisterResponse;
import com.technicalTest.technicaltest.response.WebResponse;
import com.technicalTest.technicaltest.security.jwt.JwtUtils;
import com.technicalTest.technicaltest.service.RoleService;
import com.technicalTest.technicaltest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/register")
    public ResponseEntity<WebResponse<?>> register(@RequestBody RegisterRequest request){
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setName(request.getName());

        Set<Role> roleSet = new HashSet<>();
        Set<String> roles = request.getRoles();
        for (String role : roles) {
            Role role1 = roleService.create(role);
            roleSet.add(role1);
        }

        RegisterResponse registerResponse = userService.create(user, roleSet);
        WebResponse<?> response = new WebResponse<>(
                "Successfully created new user",
                registerResponse
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}
