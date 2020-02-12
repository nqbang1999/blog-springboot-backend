package com.bangelevenn.backend.repository;

import java.util.List;
import java.util.Optional;

import com.bangelevenn.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();

    List<User> findUsersByUsernameContaining(String username);

//    List<User> findAllUsersByOrderByDateDesc();



    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    Optional<User> findByUsername(String username);
}
