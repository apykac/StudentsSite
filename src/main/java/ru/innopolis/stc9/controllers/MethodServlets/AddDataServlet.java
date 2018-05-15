package ru.innopolis.stc9.controllers.MethodServlets;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.controllers.ConstantContainer;
import ru.innopolis.stc9.services.CourseService;
import ru.innopolis.stc9.services.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddDataServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(AddDataServlet.class);
    private CourseService courseService = new CourseService();
    private StudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath()+"/defaultmenu");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ((Integer) req.getSession().getAttribute(ConstantContainer.ROLE) != 1) {
            resp.sendRedirect(req.getContextPath() + "/error?error_message=permissionError");
            return;
        }
        req.setCharacterEncoding(ConstantContainer.UTF8);
        resp.setCharacterEncoding(ConstantContainer.UTF8);
        String check = checkForCorrect(req);
        if (!check.equals("noError")) {
            resp.sendRedirect(req.getContextPath() + check);
            return;
        }
        doAdd(req);
        resp.sendRedirect(req.getContextPath() + "/method?method=" + req.getParameter("methodType"));
    }

    private String checkForCorrect (HttpServletRequest req) {
        switch (req.getParameter("methodType")) {
            case "add_course":
                if (req.getParameter("course").equals(""))
                    return "/method?method=add_course&error=addCourseError";
                break;
            case "add_student":
                if (req.getParameter("firstName").equals("") ||
                        req.getParameter("secondName").equals("")) {
                    return "/method?method=add_student&error=addStudentError";
                }
                try {
                    Integer.parseInt(req.getParameter("courseId"));
                } catch (Exception e) {
                    return "/method?method=add_student&error=addStudentError";
                }
                break;
        }
        return "noError";
    }

    private void doAdd (HttpServletRequest req) {
        switch (req.getParameter("methodType")) {
            case "add_course":
                courseService.addCourse(req.getParameter("course"));
                break;
            case "add_student":
                studentService.addStudent(
                        req.getParameter("firstName"),
                        req.getParameter("secondName"),
                        req.getParameter("middleName"),
                        Integer.parseInt(req.getParameter("courseId")));
        }
    }
}

