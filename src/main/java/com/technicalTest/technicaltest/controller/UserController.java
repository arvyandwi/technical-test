package com.technicalTest.technicaltest.controller;

import com.technicalTest.technicaltest.entity.User;
import com.technicalTest.technicaltest.response.WebResponse;
import com.technicalTest.technicaltest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<WebResponse<List<User>>> getUsers() {
        List<User> users = userService.getAll();
        WebResponse<List<User>> response = new WebResponse<>("Fetched All Users", users);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}
