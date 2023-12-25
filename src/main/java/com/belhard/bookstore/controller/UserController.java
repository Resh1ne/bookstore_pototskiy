package com.belhard.bookstore.controller;

import com.belhard.bookstore.service.UserService;
import com.belhard.bookstore.service.dto.UserDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.time.LocalDateTime;

@RequiredArgsConstructor
public class UserController implements Controller {
    private final UserService userService;

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
