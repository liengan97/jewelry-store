package com.demo.jewelry_store.repositories.impl;

import com.demo.jewelry_store.entities.User;
import com.demo.jewelry_store.repositories.PostgreSQLJDBC;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


class DefaultUserRepositoryTest {

    DefaultUserRepository defaultUserRepository = new DefaultUserRepository(new PostgreSQLJDBC());

    User user1 = new User("Kim", "kim@gmail.com","12","03033624451", "ADMIN");
    User user2 = new User("Ngaaaaan2 a", "ngaan2@gmail.com","ssssdas", "020202100", "");


    @Test
    void saveUser() throws SQLException {

        //existed userUserBuilder
        assertNull(defaultUserRepository.saveUser(user1));

        //create neww
        assertNotNull(defaultUserRepository.saveUser(user2));

    }

    @Test
    void initDBTest() {
        assertTrue(defaultUserRepository.innitDB());
    }

    @Test
    void isExistTest() throws SQLException{
        assertTrue(defaultUserRepository.isExist("kim@gmail.com"));
        assertFalse(defaultUserRepository.isExist("ngann@gmail.com"));

    }

    @Test
    void getUserTest() throws  SQLException {
        assertEquals("kim@gmail.com", defaultUserRepository.getUser(UUID.fromString("203a4bed-fa92-4a1f-b609-5939aebf9255")).getEmail());
    }

    @Test
    void deleteUserTest() throws SQLException {
        assertFalse(defaultUserRepository.deleteUser(UUID.fromString("d6eb621f-6dd0-4cdc-93f5-07f51b249b51")));
        assertTrue(defaultUserRepository.deleteUser(UUID.fromString("203a4bed-fa92-4a1f-b609-5939aebf9255")));
    }

    @Test
    void getAllUserTest() throws  SQLException {
        assertEquals(1, defaultUserRepository.getAll().size());
    }

}