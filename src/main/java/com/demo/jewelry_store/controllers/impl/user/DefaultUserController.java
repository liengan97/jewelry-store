package com.demo.jewelry_store.controllers.impl.user;

import com.demo.jewelry_store.controllers.UserController;
import com.demo.jewelry_store.entities.User;
import com.demo.jewelry_store.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("users")
public class DefaultUserController implements UserController {

    @Autowired
    final UserService userService;

    public DefaultUserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    @PostMapping("register")
    public User addUser(User user) throws SQLException {
        return userService.addUser(user);
    }

    @Override
    @GetMapping("search")
    public Set<User> findUserByName(@RequestParam String name) throws SQLException {
        return userService.findUser(name);
    }

    @Override
    @DeleteMapping("delete")
    public boolean deleteUser(@RequestParam UUID id) throws SQLException {
        return userService.deleteUser(id);
    }

    @Override
    @GetMapping("{id}")
    public User getUser(@PathVariable UUID id) throws SQLException {
        return userService.getUser(id);
    }

    @Override
    @GetMapping
    public Set<User> getAllUser() throws SQLException {
        return userService.getAll();
    }
}
