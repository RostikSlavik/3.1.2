package ru.kata.spring.boot_security.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    @Transactional
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Role> findByName(String roleName) {
        return roleRepository.findByName(roleName);
    }

    @Override
    @Transactional(readOnly = true)
    public Role findById(long id) {
        return roleRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional(readOnly = true)
    public Set<Role> findAllById(List<Long> ids) {
        return new HashSet<>(roleRepository.findAllById(ids));
    }
}
