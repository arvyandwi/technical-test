package com.technicalTest.technicaltest.repository;

import com.technicalTest.technicaltest.entity.Role;
import com.technicalTest.technicaltest.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByRole(UserRole role);

    Boolean existsByRole(UserRole role);
}
