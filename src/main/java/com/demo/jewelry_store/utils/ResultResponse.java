package com.demo.jewelry_store.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

public interface ResultResponse <T> {
    Set<T> resultSetToSet(ResultSet resultSet) throws SQLException;
    T resultSetToObject(ResultSet resultSet) throws SQLException;
}
