package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.models.Role;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface RoleService {
    List<Role> findAll();
    Role findById(long id);
    Role saveRole(Role role);
    Optional<Role> findByName(String name);
    Set<Role> findAllById(List<Long> ids);
}
