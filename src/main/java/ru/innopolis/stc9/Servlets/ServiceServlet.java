package ru.innopolis.stc9.Servlets;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServiceServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(ServiceServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding(ConstantContainer.UTF8);
            resp.setCharacterEncoding(ConstantContainer.UTF8);
            if ((Integer) req.getSession().getAttribute(ConstantContainer.ROLE) > 2) {
                resp.sendRedirect(req.getContextPath() + "/error?error_message=permissionError");
                return;
            }

            req.getRequestDispatcher("/method/" + req.getParameter("method") + ".jsp").forward(req, resp);
        } catch (IOException | ServletException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
