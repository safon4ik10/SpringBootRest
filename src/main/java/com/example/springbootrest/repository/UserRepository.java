package com.example.springbootrest.repository;

import com.example.springbootrest.entity.Authorities;
import org.springframework.stereotype.Repository;

import java.util.*;

import static com.example.springbootrest.entity.Authorities.*;

/**
 * @author Vladimir Troshin
 * @since 24.01.2023
 */

@Repository
public class UserRepository {
    private final Map<String, Creds> credsMap = prepareUsers();

    public List<Authorities> getUserAuthorities(String user, String password) {
        final Creds creds = credsMap.get(user);
        return (creds == null || !creds.password.equals(password)) ? new ArrayList<>() : creds.getAuthorities();
    }

    private Map<String, Creds> prepareUsers() {
        final Map<String, Creds> users = new HashMap<>();
        users.put("Vova", new Creds("1", Arrays.asList(DELETE, WRITE)));
        users.put("Petya", new Creds("000", Arrays.asList(READ, WRITE)));
        return users;
    }

    private static class Creds {
        private final String password;
        private final List<Authorities> authorities;

        public Creds(String password, List<Authorities> authorities) {
            this.password = password;
            this.authorities = authorities;
        }

        public String getPassword() {
            return password;
        }

        public List<Authorities> getAuthorities() {
            return authorities;
        }
    }
}
