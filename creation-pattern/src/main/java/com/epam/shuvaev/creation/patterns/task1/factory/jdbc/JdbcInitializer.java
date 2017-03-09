package com.epam.shuvaev.creation.patterns.task1.factory.jdbc;

import com.epam.shuvaev.creation.patterns.task1.factory.Initializer;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by macbook on 09.03.17
 */
public class JdbcInitializer implements Initializer {
    @Override
    public Object init() {
        System.out.println("JDBC: Initialize JDBC");
        try {
            return DriverManager.getConnection("jdbc:odbc:swing");
        } catch (SQLException e) {
            System.out.println("JDBC: Error initialization");
        }
        return null;
    }
}
