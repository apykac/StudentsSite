package ru.innopolis.stc9.Servlets.MethodServlets;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.Servlets.ConstantContainer;
import ru.innopolis.stc9.services.CourseService;
import ru.innopolis.stc9.services.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DelDataServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(DelDataServlet.class);
    private CourseService courseService = new CourseService();
    private StudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath()+"/defaultmenu");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ((Integer) req.getSession().getAttribute(ConstantContainer.ROLE) != 1) {
            resp.sendRedirect(req.getContextPath() + "/error?error_message=permissionError");
            return;
        }
        req.setCharacterEncoding(ConstantContainer.UTF8);
        resp.setCharacterEncoding(ConstantContainer.UTF8);
        Integer objectId = null;
        try {
            objectId = Integer.parseInt(req.getParameter("id"));
        } catch (Exception e) {
            resp.sendRedirect(req.getContextPath() + getErrorPath(req));
            return;
        }
        doDel(req,objectId);
        resp.sendRedirect(req.getContextPath() + "/method?method=" + req.getParameter("methodType"));
    }

    private String getErrorPath (HttpServletRequest req) {
        switch (req.getParameter("methodType")) {
            case "del_course":
                return "/method?method=del_course&error=delCourseError";
            case "del_student":
                return "/method?method=del_student&error=delStudentError";
        }
        return null;
    }

    private void doDel (HttpServletRequest req, Integer id) {
        switch (req.getParameter("methodType")) {
            case "del_course":
                courseService.delCourse(id);
                break;
            case "del_student":
                studentService.delStudent(id);
                break;
        }
    }
}
