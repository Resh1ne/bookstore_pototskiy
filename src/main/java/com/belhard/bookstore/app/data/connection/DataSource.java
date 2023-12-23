package com.belhard.bookstore.app.data.connection;

import java.sql.Connection;

public interface DataSource {
    Connection getConnection();

    @SuppressWarnings("unused")
    void close();
}
