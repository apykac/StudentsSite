package ru.innopolis.stc9.controllers.MethodServlets;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.controllers.ConstantContainer;
import ru.innopolis.stc9.pojo.Course;
import ru.innopolis.stc9.services.CourseService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PrintCoursesToPageServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(PrintCoursesToPageServlet.class);
    private static CourseService courseService = new CourseService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ((Integer) req.getSession().getAttribute(ConstantContainer.ROLE) > 2) {
            resp.sendRedirect(req.getContextPath() + "/error_page.jsp?error_message=permissionError");
            return;
        }
        req.setCharacterEncoding(ConstantContainer.UTF8);
        resp.setCharacterEncoding(ConstantContainer.UTF8);
        List<Course> courses = courseService.getCoursesByName(
                req.getParameter("course").equals("") ? null : req.getParameter("course"));
        req.setAttribute("courses", courses);
        req.getRequestDispatcher("/method/get_courses_to_page.jsp").forward(req, resp);
    }
}
