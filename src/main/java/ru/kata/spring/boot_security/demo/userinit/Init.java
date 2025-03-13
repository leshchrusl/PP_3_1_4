package ru.kata.spring.boot_security.demo.userinit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class Init {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public Init(UserService userService,
                RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void initUsers() {

        Role adminRole = new Role(1L, "ADMIN");
        Role userRole = new Role(2L, "USER");

        roleService.saveRole(adminRole);
        roleService.saveRole(userRole);

        User admin = new User("admin", "1234",
                (byte) 30, "admin@mail.ru", List.of(adminRole, userRole));

        User user1 = new User("user1", "5678",
                (byte) 27, "user1@mail.ru", List.of(userRole));

        User user2 = new User("user2", "1234",
                (byte) 21, "user2@mail.ru", List.of(userRole));

        userService.saveUser(admin);
        userService.saveUser(user1);
        userService.saveUser(user2);
    }
}
