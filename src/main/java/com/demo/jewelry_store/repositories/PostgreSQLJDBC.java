package com.demo.jewelry_store.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQLJDBC {

    // JDBC URL, username and password of PostgreSQL server
    private static final String url = "jdbc:postgresql://localhost/springbd";
    private static final String user = "postgres";
    private static final String password = "postgres";
    private static Connection connection = null;

    public PostgreSQLJDBC () {
        try {
            // Connect to the PostgresSQL database
            connection = DriverManager.getConnection(url, user, password);

            // Check if connection was successful
            if (connection != null) {
                System.out.println("Connected to the PostgreSQL server successfully.");
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() throws SQLException {
        if(connection != null)
        {
            connection.close();
            System.out.println("Disconnected to the PostgresSQL server.");
        }
    }

    public boolean createTable()  {
        var sql = "CREATE TABLE IF NOT EXISTS users ("
                + " id uuid DEFAULT gen_random_uuid(),"
                + " name VARCHAR(50),"
                + " email VARCHAR(50) UNIQUE NOT NULL,"
                + " password VARCHAR(50) NOT NULL,"
                + " phone VARCHAR(50),"
                + " role VARCHAR(50),"
                + " PRIMARY KEY (id));";

        try (var stmt = connection.createStatement())
        {

            return stmt.executeUpdate(sql) != 0;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return false;
    }


}
