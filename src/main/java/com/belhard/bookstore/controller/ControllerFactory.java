package com.belhard.bookstore.controller;

import com.belhard.bookstore.data.connection.DataSource;
import com.belhard.bookstore.data.connection.impl.DataSourceImpl;
import com.belhard.bookstore.data.dao.BookDao;
import com.belhard.bookstore.data.dao.UserDao;
import com.belhard.bookstore.data.dao.impl.BookDaoImpl;
import com.belhard.bookstore.data.dao.impl.UserDaoImpl;
import com.belhard.bookstore.service.BookService;
import com.belhard.bookstore.service.UserService;
import com.belhard.bookstore.service.impl.BookServiceImpl;
import com.belhard.bookstore.service.impl.UserServiceImpl;
import com.belhard.bookstore.util.PropertiesManager;
import com.belhard.bookstore.util.impl.PropertiesManagerImpl;

import java.util.HashMap;
import java.util.Map;

public class ControllerFactory {
    private final Map<String, Controller> controllers;
    private final DataSource dataSource;

    public ControllerFactory() {
        PropertiesManager propertiesManager = new PropertiesManagerImpl("C:\\Users\\Daniil\\IdeaProjects\\bookstore_pototskiy\\src\\main\\resources\\app.properties");
        String profile = propertiesManager.getKey("my.app.profile");
        String url = propertiesManager.getKey("my.app.db." + profile + ".url");
        String user = propertiesManager.getKey("my.app.db." + profile + ".user");
        String password = propertiesManager.getKey("my.app.db." + profile + ".password");
        String driver = propertiesManager.getKey("my.app.db." + profile + ".driver");
        dataSource = new DataSourceImpl(password, user, url, driver);
        UserDao userDao = new UserDaoImpl(dataSource);
        UserService userService = new UserServiceImpl(userDao);

        BookDao bookDao = new BookDaoImpl(dataSource);
        BookService bookService = new BookServiceImpl(bookDao);

        controllers = new HashMap<>();
        controllers.put("user", new UserController(userService));
        controllers.put("users", new UsersController(userService));
        controllers.put("books", new BooksController(bookService));
        controllers.put("error", new ErrorController());
    }

    public Controller get(String command) {
        Controller controller = controllers.get(command);
        if (controller == null) {
            controllers.get("error");
        }
        return controller;
    }

    public void close() {
        if (dataSource != null) {
            dataSource.close();
        }
    }
}
