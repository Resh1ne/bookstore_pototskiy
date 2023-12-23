package com.belhard.bookstore.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@Log4j2
@WebServlet("/demo")
public class DemoController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("My servlet!");
        String idRaw = req.getParameter("id");
        long id = Long.parseLong(idRaw);
        log.info("Client want to get an object with id: " + id);
        PrintWriter out = resp.getWriter();
        out.println("<h1>Uwu</h1><p>Id: " + id + "</p>");
        out.println("<p>" + LocalDateTime.now() + "</p>");
    }
}
