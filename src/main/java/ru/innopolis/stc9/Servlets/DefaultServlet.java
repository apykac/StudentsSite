package ru.innopolis.stc9.Servlets;

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
            if ((req == null) || (resp == null)) throw new IOException();
            req.setCharacterEncoding(ConstantContainer.UTF8);
            resp.setCharacterEncoding(ConstantContainer.UTF8);
            HttpSession httpSession = req.getSession();
            resp.sendRedirect(req.getContextPath() + "/login_valid");
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
