package com.demo.jewelry_store.repositories.impl;

import com.demo.jewelry_store.entities.User;
import com.demo.jewelry_store.repositories.PostgreSQLJDBC;
import com.demo.jewelry_store.repositories.UserRepository;
import com.demo.jewelry_store.utils.impl.DefaultUserResultResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class DefaultUserRepository implements UserRepository {

    @Autowired
    private final PostgreSQLJDBC postgreSQLJDBC;

    public DefaultUserRepository(PostgreSQLJDBC postgreSQLJDBC) {
        this.postgreSQLJDBC = postgreSQLJDBC;

        //create table if not exist
        postgreSQLJDBC.createTable();
    }

    @Override
    public boolean innitDB(){
        return postgreSQLJDBC.createTable();
    }

    @Override
    public User saveUser(User user) throws SQLException {

        var sql = "INSERT INTO public.users (name, email, password, phone, role) VALUES ('"
                + user.getName() + "','"
                + user.getEmail() + "','"
                + user.getPassword() + "','"
                + user.getPhone() + "','"
                + user.getRole() + "');";

        var sql2 = "SELECT * FROM users WHERE email='" + user.getEmail() + "';";


        Connection connection = null;
        Statement stm = null;

        try
        {
            connection = postgreSQLJDBC.getConnection();
            stm = connection.createStatement();
            int updated = stm.executeUpdate(sql);
            if (updated == 1)
                return DefaultUserResultResponse.resultSetToObject(stm.executeQuery(sql2));
        }
        catch (Exception e) {
            e.getMessage();
        }

        return null;
    }

    @Override
    public Set<User> findUser(String keyword) throws SQLException {
        var sql = "SELECT * FROM users WHERE LOWER(name) LIKE LOWER('%" + keyword + "%');";

        Connection connection = null;
        Statement stm = null;

        try
        {
            connection = postgreSQLJDBC.getConnection();
            stm = connection.createStatement();
            return DefaultUserResultResponse.resultSetToSet(stm.executeQuery(sql));
        }
        catch (Exception e) {
            e.getMessage();
        }

        return new HashSet<>();
    }

    @Override
    public boolean isExist(String email) throws SQLException {
        var sql = "SELECT * FROM users WHERE email='" + email + "';";

        Connection connection = null;
        Statement stm = null;

        try
        {
            connection =  postgreSQLJDBC.getConnection();
            stm = connection.createStatement();

            return stm.executeQuery(sql).next();
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }

//        finally {
//            if(connection != null)
//            {
//                connection.close();
//                System.out.println("Disconnected to the PostgresSQL server.");
//            }
//            if(stm != null)
//            {
//                stm.close();
//            }
//        }

        return false;
    }

    @Override
    public boolean deleteUser(UUID id) throws SQLException {
        var sql = "DELETE FROM users WHERE id='" + id + "';";

        try
        {
            var conn =  postgreSQLJDBC.getConnection();
            var stmt = conn.createStatement();
            return stmt.executeUpdate(sql) != 0;
        }

        catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }

        finally {
//            postgreSQLJDBC.closeConnection();
        }
    }

    @Override
    public User getUser(UUID id) throws SQLException {
        var sql = "SELECT * FROM users WHERE id='" + id + "';";

        Connection connection = null;
        Statement stm = null;

        try
        {
            connection = postgreSQLJDBC.getConnection();
            stm = connection.createStatement();
            return DefaultUserResultResponse.resultSetToObject(stm.executeQuery(sql));
        }
        catch (Exception e) {
            e.getMessage();
        }

        return null;
    }

    @Override
    public Set<User> getAll() throws SQLException {
        var sql = "SELECT * FROM users";

        Connection connection = null;
        Statement stm = null;

        try
        {
            connection = postgreSQLJDBC.getConnection();
            stm = connection.createStatement();
            return DefaultUserResultResponse.resultSetToSet(stm.executeQuery(sql));
        }
        catch (Exception e) {
            e.getMessage();
        }

        return null;
    }
}
