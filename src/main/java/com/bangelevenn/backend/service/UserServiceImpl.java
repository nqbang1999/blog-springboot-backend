package com.bangelevenn.backend.service;

import com.bangelevenn.backend.model.User;
import com.bangelevenn.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


//    @Override
//    public User findByUsername(String username) {
//        return userRepository.getO(username);
//    }



    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public Boolean existsByUsername(String username) {
        return null;
    }

    @Override
    public Boolean existsByEmail(String email) {
        return null;
    }

//    @Override
//    public Boolean existsByUsername(String username) {
//        return userRepository.existsByUsername(username);
//    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }

//    @Override
//    public Boolean existsByEmail(String email) {
//        return userRepository.existsByEmail(email);
//    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findUsersByUsernameContaining(String username) {
        return userRepository.findUsersByUsernameContaining(username);
    }

    @Override
    public Optional<User> findByUsername(String userName) {
        return userRepository.findByUsername(userName);
    }
}

