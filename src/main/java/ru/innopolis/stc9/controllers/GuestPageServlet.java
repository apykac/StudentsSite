package ru.innopolis.stc9.controllers;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GuestPageServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(GuestPageServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding(ConstantContainer.UTF8);
            resp.setCharacterEncoding(ConstantContainer.UTF8);
            req.getRequestDispatcher( "/guest_page.jsp").forward(req, resp);
        } catch (IOException | ServletException e) {
            logger.error(e.getMessage());
        }
    }
}
