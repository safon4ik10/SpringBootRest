package com.example.springbootrest.service;

import com.example.springbootrest.entity.Authorities;
import com.example.springbootrest.exception.InvalidCredentials;
import com.example.springbootrest.exception.UnauthorizedUser;
import com.example.springbootrest.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Vladimir Troshin
 * @since 24.01.2023
 */
@Service
public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
