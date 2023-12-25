package com.belhard.bookstore.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface Controller {
    void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
