package ru.innopolis.stc9.Servlets;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.services.UsersService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(LoginServlet.class);
    private final UsersService usersService = new UsersService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            if ((req == null) || (resp == null)) throw new IOException();
            if ((req.getParameter("logout") != null) && req.getParameter("logout").equals("true")) {
                req.getSession().invalidate();
                resp.sendRedirect(req.getContextPath() + "/login");
                return;
            }
            if ((req.getSession().getAttribute(ConstantContainer.ROLE) != null) &&
                    ((Integer) req.getSession().getAttribute(ConstantContainer.ROLE) <= 2)) {
                resp.sendRedirect(req.getContextPath() + "/defaultmenu");
                return;
            }
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
            if ((req == null) || (resp == null)) throw new IOException();
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
                resp.sendRedirect(req.getContextPath() + "/login?error=authorisationError");
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
