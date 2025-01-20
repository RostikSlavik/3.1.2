package ru.kata.spring.boot_security.demo.init;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.RoleService;
import ru.kata.spring.boot_security.demo.services.UserService;

import javax.annotation.PostConstruct;

import java.util.HashSet;
import java.util.Set;

@Component
public class InitDB {

    private final RoleService roleService;
    private final UserService userService;

    @Autowired
    public InitDB(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    private void fillDb() {
        if (roleService.findAll().isEmpty()) {

            Role adminRole = new Role("ROLE_ADMIN");
            Role userRole = new Role("ROLE_USER");

            Set<Role> rolesAdmin = new HashSet<>();
            Set<Role> rolesUser = new HashSet<>();
            rolesAdmin.add(adminRole);
            rolesUser.add(userRole);
            User admin = new User("admin", "admin", rolesAdmin);
            User user = new User("user", "user", rolesUser);

            roleService.saveRole(adminRole);
            roleService.saveRole(userRole);
            userService.saveUser(admin);
            userService.saveUser(user);

        }
    }
}