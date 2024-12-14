package com.demo.jewelry_store.services;

import com.demo.jewelry_store.entities.User;

import java.sql.SQLException;
import java.util.Set;
import java.util.UUID;

public interface UserService {
    User addUser(User user) throws SQLException;
    Set<User> findUser(String keyword) throws SQLException;
    boolean isExist(String email) throws SQLException;
    boolean deleteUser(UUID id) throws SQLException;
    User getUser(UUID id) throws SQLException;
    Set<User> getAll() throws SQLException;
}
