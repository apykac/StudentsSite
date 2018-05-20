package ru.innopolis.stc9.Servlets.MethodServlets;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.Servlets.ConstantContainer;
import ru.innopolis.stc9.services.CheckCorrectDataService;
import ru.innopolis.stc9.services.CourseService;
import ru.innopolis.stc9.services.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UpdateDataServlet extends HttpServlet {
    private CourseService courseService = new CourseService();
    private StudentService studentService = new StudentService();
    private static Logger logger = Logger.getLogger(UpdateDataServlet.class);

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
        req.setCharacterEncoding(ConstantContainer.UTF8);
        resp.setCharacterEncoding(ConstantContainer.UTF8);
        List<String> check = CheckCorrectDataService.isCorrectAddData(req.getParameterMap(), req);
        if (!check.isEmpty()) {
            req.setAttribute("errorMsg", check);
            req.getRequestDispatcher("/method?method=" + req.getParameter("methodType") + "&error=true").forward(req,resp);
            return;
        }
        doUpdate(req);
        resp.sendRedirect(req.getContextPath() + "/method?method=" + req.getParameter("methodType"));
    }

    private void doUpdate(HttpServletRequest req) {
        switch (req.getParameter("methodType")) {
            case "update_course":
                courseService.updateCourse(req.getParameterMap());
                break;
            case "update_student":
                studentService.updateStudent(req.getParameterMap());
        }
    }
}
