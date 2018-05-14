package ru.innopolis.stc9.controllers;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DefaultServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(DefaultServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding(ConstantContainer.UTF8);
            resp.setCharacterEncoding(ConstantContainer.UTF8);
            HttpSession httpSession = req.getSession();
            if (httpSession.getAttribute(ConstantContainer.ROLE) == null) {
                req.getSession().setAttribute(ConstantContainer.ROLE, 3);
                req.getSession().setAttribute(ConstantContainer.USERNAME, "guest");
            }
            resp.sendRedirect(req.getContextPath() + "/login_valid");
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
