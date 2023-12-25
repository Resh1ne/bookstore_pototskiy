package com.belhard.bookstore.controller;

import com.belhard.bookstore.data.connection.DataSource;
import com.belhard.bookstore.data.connection.impl.DataSourceImpl;
import com.belhard.bookstore.data.dao.UserDao;
import com.belhard.bookstore.data.dao.impl.UserDaoImpl;
import com.belhard.bookstore.service.UserService;
import com.belhard.bookstore.service.dto.UserDto;
import com.belhard.bookstore.service.impl.UserServiceImpl;
import com.belhard.bookstore.util.PropertiesManager;
import com.belhard.bookstore.util.impl.PropertiesManagerImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/user")
public class UserController extends HttpServlet {
    private UserService userService;
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        UserDao userDao = getUserDao();
        userService = new UserServiceImpl(userDao);
    }

    @SneakyThrows
    @Override
    public void destroy() {
        dataSource.close();
    }

    private UserDao getUserDao() {
        PropertiesManager propertiesManager = new PropertiesManagerImpl("C:\\Users\\Daniil\\IdeaProjects\\bookstore_pototskiy\\src\\main\\resources\\app.properties");
        String profile = propertiesManager.getKey("my.app.profile");
        String url = propertiesManager.getKey("my.app.db." + profile + ".url");
        String user = propertiesManager.getKey("my.app.db." + profile + ".user");
        String password = propertiesManager.getKey("my.app.db." + profile + ".password");
        String driver = propertiesManager.getKey("my.app.db." + profile + ".driver");
        dataSource = new DataSourceImpl(password, user, url, driver);
        return new UserDaoImpl(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String idRaw = req.getParameter("id");
            long id = Long.parseLong(idRaw);
            UserDto user = userService.getById(id);
            req.setAttribute("user", user);
            req.setAttribute("date", LocalDateTime.now().toString());
            req.getRequestDispatcher("jsp/user/user.jsp").forward(req, resp);
        } catch (RuntimeException e) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
