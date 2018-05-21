package ru.innopolis.stc9.Servlets.MethodServlets;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.Servlets.ConstantContainer;
import ru.innopolis.stc9.services.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UpdateDataServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(UpdateDataServlet.class);
    private ObjectService objectService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath() + "/defaultmenu");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ((Integer) req.getSession().getAttribute(ConstantContainer.ROLE) != 1) {
            resp.sendRedirect(req.getContextPath() + "/error?error_message=permissionError");
            return;
        }
        objectService = CreateObjectService.create(req);
        req.setCharacterEncoding(ConstantContainer.UTF8);
        resp.setCharacterEncoding(ConstantContainer.UTF8);
        List<String> check = objectService.isCorrectData(req.getParameterMap());
        if (!check.isEmpty()) {
            req.setAttribute("errorMsg", check);
            req.getRequestDispatcher("/method?method=" + req.getParameter("methodType") + "&error=true").forward(req,resp);
            return;
        }
        objectService.updateObject(req.getParameterMap());
        resp.sendRedirect(req.getContextPath() + "/method?method=" + req.getParameter("methodType"));
    }
}
