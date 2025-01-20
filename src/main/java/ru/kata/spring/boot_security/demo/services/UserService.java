package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void saveUser(User user);
    User findById(Long id);
    void deleteById(Long id);
    List<User> findAll();
    Optional<User> findByUsername(String username);
}
