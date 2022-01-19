package com.technicalTest.technicaltest.service.impl;

import com.technicalTest.technicaltest.entity.Role;
import com.technicalTest.technicaltest.entity.User;
import com.technicalTest.technicaltest.entity.UserDetailImpl;
import com.technicalTest.technicaltest.exception.UserActiveException;
import com.technicalTest.technicaltest.exception.UsernameAlreadyExistAuthenticationException;
import com.technicalTest.technicaltest.repository.UserRepository;
import com.technicalTest.technicaltest.response.RegisterResponse;
import com.technicalTest.technicaltest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()){
            if (!user.get().getIsDeleted()){
                return UserDetailImpl.build(user.get());
            }else {
                throw new UserActiveException(HttpStatus.BAD_REQUEST, "This user is not active");
            }
        }else {
            throw new UsernameNotFoundException("Username doesn't exist");
        }
    }

    @Override
    public RegisterResponse create(User user, Set<Role> roles) {
        Optional<User> users = userRepository.findByUsername(user.getUsername());
        if (users.isPresent()) {
            throw new UsernameAlreadyExistAuthenticationException(HttpStatus.BAD_REQUEST,"Username already exists !");
        } else {
            user.setRoles(roles);
            User save = userRepository.save(user);

            Set<String> strRoles = new HashSet<>();
            for (Role role : save.getRoles()) {
                strRoles.add(role.getRole().name());
            }

            return new RegisterResponse(
                    save.getId(),
                    save.getUsername(),
                    save.getName(),
                    strRoles,
                    save.getCreatedAt(),
                    save.getUpdatedAt()
            );
        }
    }
}
