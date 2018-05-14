package ru.innopolis.stc9.controllers;

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
            String param = req.getParameter("method");
            if ((Integer)req.getSession().getAttribute(ConstantContainer.ROLE) >2 ) {
                resp.sendRedirect(req.getContextPath() + "/error_page.jsp?error_message=permissionError");
                return;
            }
            if (param.equals("get_students")) {
                req.getRequestDispatcher("/method/get_students.jsp").forward(req, resp);
                return;
            }
            if (param.equals("add_student")) {
                req.getRequestDispatcher("/method/add_student.jsp").forward(req,resp);
                return;
            }
            if (param.equals("del_student")) {
                req.getRequestDispatcher("/method/del_student.jsp").forward(req,resp);
                return;
            }
            if (param.equals("add_course")) {
                req.getRequestDispatcher("/method/add_course.jsp").forward(req,resp);
                return;
            }
        } catch (IOException | ServletException e) {
            logger.error(e.getMessage());
        }
    }
}
