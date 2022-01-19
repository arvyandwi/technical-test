package com.technicalTest.technicaltest.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginResponse {

    private String token;

    private Set<String> roles;
}
