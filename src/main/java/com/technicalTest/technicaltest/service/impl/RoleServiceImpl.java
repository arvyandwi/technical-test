package com.technicalTest.technicaltest.service.impl;

import com.technicalTest.technicaltest.entity.Role;
import com.technicalTest.technicaltest.exception.NotFoundException;
import com.technicalTest.technicaltest.repository.RoleRepository;
import com.technicalTest.technicaltest.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

import static com.technicalTest.technicaltest.entity.UserRole.ADMIN_ROLE;
import static com.technicalTest.technicaltest.entity.UserRole.USER_ROLE;

public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role create(String strRole) {
        if (strRole == null) {
            if (!roleRepository.existsByRole(USER_ROLE)) {
                Role userRole = new Role(USER_ROLE);
                return roleRepository.save(userRole);
            }
            return roleRepository.findByRole(USER_ROLE)
                    .orElseThrow(() -> new NotFoundException("Error: Role not found"));
        } else {
            if (strRole.equalsIgnoreCase("admin")) {
                if (!roleRepository.existsByRole(ADMIN_ROLE)) {
                    Role adminRole = new Role(ADMIN_ROLE);
                    return roleRepository.save(adminRole);
                }
                return roleRepository.findByRole(ADMIN_ROLE)
                        .orElseThrow(() -> new NotFoundException("Error: Role not found"));
            } else {
                if (!roleRepository.existsByRole(USER_ROLE)) {
                    Role userRole = new Role(USER_ROLE);
                    return roleRepository.save(userRole);
                }
                return roleRepository.findByRole(USER_ROLE)
                        .orElseThrow(() -> new NotFoundException("Error: Role not found"));
            }
        }
    }
}
