package com.technicalTest.technicaltest.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterResponse {

    private String id;

    private String username;

    private String name;

    private Set<String> roles;

    private Date createdAt;

    private Date updatedAt;
}
