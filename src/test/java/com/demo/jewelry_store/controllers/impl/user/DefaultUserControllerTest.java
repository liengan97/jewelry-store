package com.demo.jewelry_store.controllers.impl.user;

import com.demo.jewelry_store.controllers.UserController;
import com.demo.jewelry_store.entities.User;
import com.demo.jewelry_store.repositories.PostgreSQLJDBC;
import com.demo.jewelry_store.repositories.impl.DefaultUserRepository;
import com.demo.jewelry_store.services.impl.user.DefaultUserService;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.HttpClientErrorException;

import java.sql.SQLException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class DefaultUserControllerTest {

    UserController userController = new DefaultUserController( new DefaultUserService(new DefaultUserRepository(new PostgreSQLJDBC())));

    User user1 = new User("Tsdas 777", "777@gmail.com","12","7777", "ADMIN");
//    User user2 = new User("co 2", "colll2@gmail.com","ssssdas", "020202100", "");

    @Test
    void addUserTest() throws SQLException {

        //400 BAD REQUEST
//        assertThrows(HttpClientErrorException.class, () -> userController.addUser(user1));
//
//        assertThrows(HttpClientErrorException.class, () -> userController.addUser(new User("Ngan")));

        //edit user2 before this Test
        assertEquals("777@gmail.com",userController.addUser(user1).getEmail());
    }

    @Test
    void findUserTest() throws SQLException {
        //2
        assertEquals(2,userController.findUserByName("co").size());

        //all
        assertEquals(userController.getAllUser().size(),userController.findUserByName("").size());
        //NOT FOUND
        assertEquals(0,userController.findUserByName("abdhgdag").size());

    }


    @Test
    void deleteUserTest() throws SQLException {
        assertTrue(userController.deleteUser(UUID.fromString("cf6e318b-c815-4449-ae27-2668984147b5")));
        assertFalse(userController.deleteUser(UUID.fromString("cf6e318b-c815-4449-ae27-2668984147b5")));
    }

    @Test
    void getUserTest() throws SQLException {
        assertEquals("colll2@gmail.com",userController.getUser(UUID.fromString("00ddf0de-bf09-41a3-8e44-e5966d81c481")).getEmail());
    }

    @Test
    void getAllTest() throws SQLException {

        assertEquals(userController.getAllUser().size(),userController.findUserByName("").size());

    }
}