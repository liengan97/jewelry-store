package com.demo.jewelry_store.repositories;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostgreSQLJDBCTest {
    @Test
    void  creatTableTest()
    {
        PostgreSQLJDBC postgreSQLJDBC = new PostgreSQLJDBC();
        assertTrue(postgreSQLJDBC.createTable());
    }

}