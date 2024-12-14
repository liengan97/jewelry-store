package com.demo.jewelry_store.services.impl.user;

import com.demo.jewelry_store.entities.User;
import com.demo.jewelry_store.repositories.PostgreSQLJDBC;
import com.demo.jewelry_store.repositories.impl.DefaultUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.HttpClientErrorException;

import java.sql.SQLException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class DefaultUserServiceTest {

    DefaultUserService defaultUserService = new DefaultUserService(new DefaultUserRepository(new PostgreSQLJDBC()));

    User user1 = new User("Se", "se@gmail.com","12","03033624451", "ADMIN");
    User user2 = new User("Se2 a", "se2@gmail.com","ssssdas", "020202100", "");

    @Test
    void addUserTest() throws SQLException {

        //400 BAD REQUEST
        assertThrows(HttpClientErrorException.class, () -> defaultUserService.addUser(user1));

        assertThrows(HttpClientErrorException.class, () -> defaultUserService.addUser(new User("Ngan")));

        //edit user2 before this Test
        assertEquals(user2.getEmail(),defaultUserService.addUser(user2).getEmail());
    }

    @Test
    void findUserTest() throws SQLException {
        //2
        assertEquals(2,defaultUserService.findUser("se").size());

        //all
        assertEquals(defaultUserService.getAll().size(),defaultUserService.findUser("").size());
        //NOT FOUND
        assertEquals(0,defaultUserService.findUser("abdhgdag").size());

    }

    @Test
    void isExistTest() throws SQLException {
        assertTrue(defaultUserService.isExist("se@gmail.com"));
        assertFalse(defaultUserService.isExist("seeee@gmail.com"));
    }

    @Test
    void deleteUserTest() throws SQLException {
        assertTrue(defaultUserService.deleteUser(UUID.fromString("3ab28b93-e069-4e9d-8513-45b2d90795a6")));
        assertFalse(defaultUserService.deleteUser(UUID.fromString("3ab28b93-e069-4e9d-8513-45b2d90795a6")));
    }

    @Test
    void getUserTest() throws SQLException {
        assertEquals(user1.getEmail(),defaultUserService.getUser(UUID.fromString("b18bab34-c1a8-484d-9a36-46138fabb770")).getEmail());
    }

    @Test
    void getAllTest() throws SQLException {

        assertEquals(defaultUserService.getAll().size(),defaultUserService.findUser("").size());

    }
}