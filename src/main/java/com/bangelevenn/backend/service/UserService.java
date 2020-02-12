package com.bangelevenn.backend.service;

import com.bangelevenn.backend.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
//    User findByUsername(String username);


    List<User> findAll();

    User findById(Long id);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    void delete(long id);

    User save(User user);

    List<User> findUsersByUsernameContaining(String username);

    Optional<User> findByUsername(String userName);
}
