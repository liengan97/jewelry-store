package com.demo.jewelry_store.services.impl.user;

import com.demo.jewelry_store.entities.User;
import com.demo.jewelry_store.repositories.PostgreSQLJDBC;
import com.demo.jewelry_store.repositories.UserRepository;
import com.demo.jewelry_store.repositories.impl.DefaultUserRepository;
import com.demo.jewelry_store.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.HttpClientErrorException;

import java.sql.SQLException;
import java.util.Set;
import java.util.UUID;

public class DefaultUserService implements UserService {

    @Autowired
    private final UserRepository userRepository;

    public DefaultUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) throws SQLException {

        if(user.getEmail() == null  || user.getPassword() == null || isExist(user.getEmail())) {
            throw new HttpClientErrorException(HttpStatusCode.valueOf(400),"BAD REQUEST");
        }

        else
            return userRepository.saveUser(user);
    }

    @Override
    public Set<User> findUser(String keyword) throws SQLException {
        return userRepository.findUser(keyword);
    }

    @Override
    public boolean isExist(String email) throws SQLException {
        return userRepository.isExist(email);
    }

    @Override
    public boolean deleteUser(UUID id) throws SQLException {
        return userRepository.deleteUser(id);
    }

    @Override
    public User getUser(UUID id) throws SQLException {
        return userRepository.getUser(id);
    }

    @Override
    public Set<User> getAll() throws SQLException {
        return userRepository.getAll();
    }
}
