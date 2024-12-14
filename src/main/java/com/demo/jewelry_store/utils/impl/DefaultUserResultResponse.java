package com.demo.jewelry_store.utils.impl;

import com.demo.jewelry_store.entities.User;
import com.demo.jewelry_store.utils.ResultResponse;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class DefaultUserResultResponse {
    public static Set<User> resultSetToSet(ResultSet resultSet) throws SQLException {
        Set<User> users = new HashSet<>();

        while(resultSet.next()) {

            User user = new User();
            user.setId((UUID) resultSet.getObject("id"));
            user.setName(resultSet.getString("name"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setRole(resultSet.getString("role"));

            users.add(user);
        }

        resultSet.close();

        return users;
    }

    public  static User resultSetToObject(ResultSet resultSet) throws SQLException {
        User user = new User();
        if (resultSet.next())
        {
            user.setId((UUID) resultSet.getObject("id"));
            user.setName(resultSet.getString("name"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setRole(resultSet.getString("role"));
        }

        resultSet.close();

        return user;
    }
}
