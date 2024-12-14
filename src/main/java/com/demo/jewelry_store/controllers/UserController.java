package com.demo.jewelry_store.controllers;

import com.demo.jewelry_store.entities.User;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLException;
import java.util.Set;
import java.util.UUID;

public interface UserController {
    User addUser(@RequestBody User user) throws SQLException;
    Set<User> findUserByKeyword(String keyword) throws SQLException;
    boolean deleteUser(UUID id) throws SQLException;
    User getUser(UUID id) throws SQLException;
    Set<User> getAllUser() throws SQLException;
}
