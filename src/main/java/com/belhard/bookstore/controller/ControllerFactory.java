package com.belhard.bookstore.controller;

import com.belhard.bookstore.data.connection.DataSource;
import com.belhard.bookstore.data.connection.impl.DataSourceImpl;
import com.belhard.bookstore.data.dao.UserDao;
import com.belhard.bookstore.data.dao.impl.UserDaoImpl;
import com.belhard.bookstore.service.UserService;
import com.belhard.bookstore.service.impl.UserServiceImpl;
import com.belhard.bookstore.util.PropertiesManager;
import com.belhard.bookstore.util.impl.PropertiesManagerImpl;

public class ControllerFactory {
    private final UsersController usersController;
    private final UserController userController;
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
        userController = new UserController(userService);
        usersController = new UsersController(userService);
    }

    public Controller get(String command) {
        switch (command) {
            case "user" -> {
                return userController;
            }
            case "users" -> {
                return usersController;
            }
            default -> throw new RuntimeException();
        }
    }

    public void close() {
        if (dataSource != null) {
            dataSource.close();
        }
    }
}
