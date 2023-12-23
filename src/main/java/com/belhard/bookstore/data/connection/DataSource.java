package com.belhard.bookstore.data.connection;

import java.sql.Connection;

public interface DataSource {
    Connection getConnection();

    @SuppressWarnings("unused")
    void close();
}
