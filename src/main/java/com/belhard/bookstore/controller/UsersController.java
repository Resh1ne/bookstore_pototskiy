package com.belhard.bookstore.controller;

import com.belhard.bookstore.service.UserService;
import com.belhard.bookstore.service.dto.UserDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
public class UsersController implements Controller {
    private final UserService userService;

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<UserDto> users = userService.getAll();
        req.setAttribute("users", users);
        req.getRequestDispatcher("jsp/user/users.jsp").forward(req, resp);
    }
}
