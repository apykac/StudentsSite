package ru.innopolis.stc9.controllers;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.services.UsersService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {
    private static Logger logger = Logger.getLogger(LoginController.class);
    private final UsersService usersService = new UsersService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding(ConstantContainer.UTF8);
            resp.setCharacterEncoding(ConstantContainer.UTF8);
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding(ConstantContainer.UTF8);
            resp.setCharacterEncoding(ConstantContainer.UTF8);
            String login = req.getParameter("userName");
            String password = req.getParameter("userPassword");
            int userResult = usersService.checkAuth(login, password);
            if (userResult != 0) {
                req.getSession().setAttribute(ConstantContainer.USERNAME, login);
                req.getSession().setAttribute(ConstantContainer.ROLE, userResult);
                resp.sendRedirect(req.getContextPath() + "/login_valid");
            } else {
                resp.sendRedirect(req.getContextPath() + "/error_page.jsp?error_message=authorisationError");
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
