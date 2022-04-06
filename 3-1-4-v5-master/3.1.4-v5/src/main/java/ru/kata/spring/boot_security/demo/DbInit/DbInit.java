package ru.kata.spring.boot_security.demo.DbInit;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.roleService.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.HashSet;

@Component
public class DbInit implements InitializingBean {
    private final UserService userService;
    private final RoleService roleService;

    public DbInit(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        try {
            HashSet<Role> roles = new HashSet<>();
            roleService.add(new Role( "ROLE_ADMIN"));
            roleService.add(new Role( "ROLE_USER"));
            Role role = roleService.getRoleById(1L);
            roles.add(role);
            User user = new User("Alexander", "Kondratyev", "info@ivawood.com", "admin");

            userService.save(user, roles);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("При попытке заполнить базу данных возникла ошибка!");
        }
    }
}





