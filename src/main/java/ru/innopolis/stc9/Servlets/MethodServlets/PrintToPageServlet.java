package ru.innopolis.stc9.Servlets.MethodServlets;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.Servlets.ConstantContainer;
import ru.innopolis.stc9.pojo.DBObject;
import ru.innopolis.stc9.services.CourseService;
import ru.innopolis.stc9.services.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PrintToPageServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(PrintToPageServlet.class);
    private static CourseService courseService = new CourseService();
    private static StudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath()+"/defaultmenu");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ((Integer) req.getSession().getAttribute(ConstantContainer.ROLE) > 2) {
            resp.sendRedirect(req.getContextPath() + "/error?error_message=permissionError");
            return;
        }
        req.setCharacterEncoding(ConstantContainer.UTF8);
        resp.setCharacterEncoding(ConstantContainer.UTF8);
        List<DBObject> objects = listCreator(req);
        req.setAttribute("objects", objects);
        req.getRequestDispatcher(getDispatcherPath(req)).forward(req, resp);
    }

    private List<DBObject> listCreator(HttpServletRequest req) {
        switch (req.getParameter("methodType")) {
            case "courses_to_page":
                return courseService.getCourses(req.getParameterMap(),"methodType");
            case "students_to_page":
                return studentService.getStudents(req.getParameterMap(),"methodType");
        }
        return null;
    }

    private String getDispatcherPath(HttpServletRequest req) {
        switch (req.getParameter("methodType")) {
            case "courses_to_page":
                return "/method/get_courses_to_page.jsp";
            case "students_to_page":
                return "/method/get_students_to_page.jsp";
        }
        return null;
    }
}

