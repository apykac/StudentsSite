package ru.innopolis.stc9.controllers.MethodServlets;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.controllers.ConstantContainer;
import ru.innopolis.stc9.services.CourseService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddCourseServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(AddCourseServlet.class);
    private CourseService courseService = new CourseService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ((Integer)req.getSession().getAttribute(ConstantContainer.ROLE) != 1){
            resp.sendRedirect(req.getContextPath() + "/error_page.jsp?error_message=permissionError");
            return;
        }
        req.setCharacterEncoding(ConstantContainer.UTF8);
        resp.setCharacterEncoding(ConstantContainer.UTF8);
        String courseName = req.getParameter("course");
        if (courseName.equals("")) {
            resp.sendRedirect(req.getContextPath() + "/error_page.jsp?error_message=addCourseError");
            return;
        }
        courseService.addCourse(courseName);
        resp.sendRedirect(req.getContextPath() + "/method?method=add_course");
    }
}
