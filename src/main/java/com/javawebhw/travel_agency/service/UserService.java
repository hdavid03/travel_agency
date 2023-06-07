package com.javawebhw.travel_agency.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.javawebhw.travel_agency.model.User;
import com.javawebhw.travel_agency.repository.UserRepository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private static final String USER_NOT_FOUND = "User by %s=%s not found!";

    @Autowired
    private final UserRepository userRepository;
    
    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                    String.format(USER_NOT_FOUND, "id", Long.toString(id)))
                );
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException(
                    String.format(USER_NOT_FOUND, "email", email))
                );
       
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findUserByEmail(username);
    }

}
