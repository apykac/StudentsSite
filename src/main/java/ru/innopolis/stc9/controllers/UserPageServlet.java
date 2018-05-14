package ru.innopolis.stc9.controllers;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserPageServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(GuestPageServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding(ConstantContainer.UTF8);
            resp.setCharacterEncoding(ConstantContainer.UTF8);
            if ((Integer) req.getSession().getAttribute(ConstantContainer.ROLE) < 3)
                req.getRequestDispatcher("/user_page.jsp").forward(req, resp);
            else
                resp.sendRedirect(req.getContextPath() + "/error_page.jsp?error_message=permissionError");
        } catch (IOException | ServletException e) {
            logger.error(e.getMessage());
        }
    }
}
