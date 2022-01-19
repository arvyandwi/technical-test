package com.technicalTest.technicaltest.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterRequest {

    private String username;

    private String password;

    private String name;

    private Set<String> roles;
}
