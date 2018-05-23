package ru.innopolis.stc9.Servlets.MethodServlets;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.Servlets.ConstantContainer;
import ru.innopolis.stc9.pojo.DBObject;
import ru.innopolis.stc9.services.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PrintToPageServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(PrintToPageServlet.class);
    private ObjectService objectService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ((req == null) || (resp == null)) throw new IOException();
        resp.sendRedirect(req.getContextPath() + "/defaultmenu");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ((req == null) || (resp == null)) throw new IOException();
        if ((Integer) req.getSession().getAttribute(ConstantContainer.ROLE) > 2) {
            resp.sendRedirect(req.getContextPath() + "/error?error_message=permissionError");
            return;
        }
        objectService = CreateObjectService.create(req);
        req.setCharacterEncoding(ConstantContainer.UTF8);
        resp.setCharacterEncoding(ConstantContainer.UTF8);
        List<DBObject> objects = objectService.getObjects(req.getParameterMap(), "methodType");
        req.setAttribute("objects", objects);
        req.getRequestDispatcher("/method/" + req.getParameter("methodType") + ".jsp").forward(req, resp);
    }
}

