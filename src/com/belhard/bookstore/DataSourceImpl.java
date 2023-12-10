package com.belhard.bookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSourceImpl implements DataSource {
    private final String password;
    private final String user;
    private final String url;

    public DataSourceImpl(String password, String user, String url) {
        this.password = password;
        this.user = user;
        this.url = url;
    }

    @Override
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
