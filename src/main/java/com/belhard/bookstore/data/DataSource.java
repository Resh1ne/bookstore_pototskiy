package com.belhard.bookstore.data;

import java.sql.Connection;

public interface DataSource {
    Connection getConnection();
}
